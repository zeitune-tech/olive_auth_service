package sn.zeitune.oliveinsuranceauthservice.app.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.zeitune.oliveinsuranceauthservice.app.dto.AuthenticationRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.AuthenticationResponse;
import sn.zeitune.oliveinsuranceauthservice.app.enums.UserRole;
import sn.zeitune.oliveinsuranceauthservice.app.services.AuthenticationService;

@RestController
@RequestMapping("/")
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

        return ResponseEntity.ok(authService.refreshToken(refreshToken));
    }
}
