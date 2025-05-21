package sn.zeitune.oliveinsuranceauthservice.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.zeitune.oliveinsuranceauthservice.dto.AuthenticationRequest;
import sn.zeitune.oliveinsuranceauthservice.dto.AuthenticationResponse;
import sn.zeitune.oliveinsuranceauthservice.enums.UserRole;
import sn.zeitune.oliveinsuranceauthservice.services.impl.AuthenticationService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/admin/login")
    public ResponseEntity<AuthenticationResponse> authenticateAdmin(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authService.authenticateAdmin(request));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthenticationResponse> refreshToken(
            HttpServletRequest request
    ) throws Exception {
        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().build();
        }
        final String refreshToken = authHeader.substring(7);

        UserRole userType = request.getHeader("X-User-Type") != null ?
                UserRole.valueOf(request.getHeader("X-User-Type")) : null;

        return ResponseEntity.ok(authService.refreshToken(refreshToken, userType));
    }
}
