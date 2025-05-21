package sn.zeitune.oliveinsuranceauthservice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Employee;
import sn.zeitune.oliveinsuranceauthservice.app.enums.UserRole;
import sn.zeitune.oliveinsuranceauthservice.app.entities.User;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final KeyProviderService keyProvider;

    @Value("${jwt.user.expiration}")
    private long userExp;

    @Value("${jwt.admin.expiration}")
    private long adminExp;

    @Value("${jwt.refresh.expiration}")
    private long refreshExpiration;


    private String buildToken(Map<String, Object> claims, UserDetails userDetails, long expiration, PrivateKey privateKey) {
        var authorities = userDetails.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority).toList();

        return Jwts.builder()
                .claims().add(claims).and()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .claim("authorities", authorities)
                .signWith(privateKey, Jwts.SIG.RS256)
                .compact();
    }

    public String generateToken(UserDetails userDetails) {
        HashMap<String, Object> claims = new HashMap<>();
        UserRole userType = ((User) userDetails).getRole();
        claims.put("userType", userType);
        if (userDetails instanceof Employee) {
            claims.put("managementEntity", ((Employee) userDetails).getManagementEntity());
        }

        try {
            PrivateKey privateKey = keyProvider.getPrivateKey(userType);
            long expiration = getExpiration(userType);
            return buildToken(claims, userDetails, expiration, privateKey);
        } catch (Exception e) {
            throw new RuntimeException("Erreur génération token", e);
        }
    }

    public String generateRefreshToken(UserDetails userDetails) {
        HashMap<String, Object> claims = new HashMap<>();
        UserRole userType = ((User) userDetails).getRole();
        claims.put("userType", userType);
        claims.put("refresh", true);

        try {
            PrivateKey privateKey = keyProvider.getPrivateKey(userType);
            return buildToken(claims, userDetails, refreshExpiration, privateKey);
        } catch (Exception e) {
            throw new RuntimeException("Erreur génération refresh token", e);
        }
    }


    private long getExpiration(UserRole userType) {
        if (userType == UserRole.ADMIN) {
            return adminExp;
        } else if (userType == UserRole.USER) {
            return userExp;
        }
        throw new IllegalArgumentException("Invalid user type: " + userType);
    }

    public String extractUsername(String token, UserRole userType) throws Exception {
        return extractClaim(token, Claims::getSubject, userType);
    }


    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver, UserRole userType) throws Exception {
        final Claims claims = extractAllClaims(token, userType);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token, UserRole userType) throws Exception {
        PublicKey publicKey = keyProvider.getPublicKey(userType);
        return Jwts.parser()
                .verifyWith(publicKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public UserRole extractUserRoleWithoutValidation(String token) {
        String[] parts = token.split("\\.");
        if (parts.length != 3) throw new IllegalArgumentException("Invalid JWT");

        String payloadJson = new String(Base64.getUrlDecoder().decode(parts[1]));
        JSONObject payload = new JSONObject(payloadJson);
        return UserRole.valueOf(payload.getString("userType"));
    }

    public boolean isTokenValid(String token, UserDetails userDetails) throws Exception {
        final String username = extractUsername(token, ((User) userDetails).getRole());
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token, ((User) userDetails).getRole()));
    }

    private boolean isTokenExpired(String token, UserRole userType) throws Exception {
        Date expiration = extractClaim(token, Claims::getExpiration, userType);
        return expiration.before(new Date());
    }
}

