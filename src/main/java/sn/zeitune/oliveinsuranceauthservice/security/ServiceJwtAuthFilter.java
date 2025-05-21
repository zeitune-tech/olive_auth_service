package sn.zeitune.oliveinsuranceauthservice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.security.PublicKey;
import java.util.List;

@RequiredArgsConstructor
public class ServiceJwtAuthFilter extends OncePerRequestFilter {

    private final KeyProviderService keyProvider;

    @Value("${services.jwt.issuer}")
    private String expectedIssuer;

    @Value("${services.jwt.audience}")
    private String expectedAudience;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);
        try {
            var claims = Jwts.parser()
                    .verifyWith(keyProvider.getServicePublicKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            if (!expectedIssuer.equals(claims.getIssuer())
                    || !claims.getAudience().contains(expectedAudience)) {
                throw new SecurityException("Invalid service token context");
            }

            String issuer = claims.getIssuer();
            PublicKey key = keyProvider.getTrustedPublicKey(issuer);

            Claims verifiedClaims = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            // Authentifier en tant que service système
            var auth = new UsernamePasswordAuthenticationToken("internal-service", null, List.of());
            SecurityContextHolder.getContext().setAuthentication(auth);

        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"Invalid service token\"}");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
