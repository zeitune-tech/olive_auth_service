package sn.zeitune.oliveinsuranceauthservice.app.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sn.zeitune.oliveinsuranceauthservice.app.dto.AuthenticationRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.AuthenticationResponse;
import sn.zeitune.oliveinsuranceauthservice.app.enums.UserRole;
import sn.zeitune.oliveinsuranceauthservice.app.entities.User;
import sn.zeitune.oliveinsuranceauthservice.app.repositories.UserRepository;
import sn.zeitune.oliveinsuranceauthservice.security.JwtService;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.email(),
                request.password()
            )
        );

        var user = userRepository.findByEmailAndRole(request.email(), UserRole.USER)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        var accessToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return new AuthenticationResponse(accessToken, refreshToken);
    }

    public AuthenticationResponse refreshToken(String refreshToken, UserRole userType) throws Exception {
        final String userEmail = jwtService.extractUsername(refreshToken, userType);
        if (userEmail != null) {
            var user = userRepository.findByEmail(userEmail)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                return new AuthenticationResponse(accessToken, refreshToken);
            }
        }

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Validate refresh token explicitly with correct secret
        if (!jwtService.isTokenValid(refreshToken, user)) {
            throw new IllegalArgumentException("Invalid refresh token");
        }

        String newAccessToken = jwtService.generateToken(user);
        return new AuthenticationResponse(newAccessToken, refreshToken);
    }

    public AuthenticationResponse authenticateAdmin(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        var user = userRepository.findByEmailAndRole(request.email(), UserRole.ADMIN)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        var accessToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return new AuthenticationResponse(accessToken, refreshToken);
    }
}
