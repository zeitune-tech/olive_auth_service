package sn.zeitune.oliveinsuranceauthservice.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import sn.zeitune.oliveinsuranceauthservice.app.enums.UserRole;

import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class KeyProviderService {

    @Value("${jwt.user.private-key}")
    private Resource userPrivateRes;

    @Value("${jwt.user.public-key}")
    private Resource userPublicRes;

    @Value("${jwt.admin.private-key}")
    private Resource adminPrivateRes;

    @Value("${jwt.admin.public-key}")
    private Resource adminPublicRes;

    @Value("${jwt.service.private-key}")
    private Resource servicePrivateRes;

    @Value("${jwt.service.public-key}")
    private Resource servicePublicRes;

    @Value("#{${trusted-services:{}}}")
    private Map<String, Resource> trustedServiceKeys;


    private PrivateKey cachedUserPrivateKey;
    private PublicKey cachedUserPublicKey;

    private PrivateKey cachedAdminPrivateKey;
    private PublicKey cachedAdminPublicKey;

    private PrivateKey cachedServicePrivateKey;
    private PublicKey cachedServicePublicKey;

    private final Map<String, PublicKey> cachedTrustedKeys = new ConcurrentHashMap<>();

    public synchronized PrivateKey getPrivateKey(UserRole role) throws Exception {
        if (role == UserRole.ADMIN) {
            if (cachedAdminPrivateKey == null) {
                cachedAdminPrivateKey = loadPrivateKey(adminPrivateRes);
            }
            return cachedAdminPrivateKey;
        } else {
            if (cachedUserPrivateKey == null) {
                cachedUserPrivateKey = loadPrivateKey(userPrivateRes);
            }
            return cachedUserPrivateKey;
        }
    }

    public synchronized PublicKey getPublicKey(UserRole role) throws Exception {
        if (role == UserRole.ADMIN) {
            if (cachedAdminPublicKey == null) {
                cachedAdminPublicKey = loadPublicKey(adminPublicRes);
            }
            return cachedAdminPublicKey;
        } else {
            if (cachedUserPublicKey == null) {
                cachedUserPublicKey = loadPublicKey(userPublicRes);
            }
            return cachedUserPublicKey;
        }
    }

    public synchronized PrivateKey getServicePrivateKey() throws Exception {
        if (cachedServicePrivateKey == null) {
            cachedServicePrivateKey = loadPrivateKey(servicePrivateRes);
        }
        return cachedServicePrivateKey;
    }

    public synchronized PublicKey getServicePublicKey() throws Exception {
        if (cachedServicePublicKey == null) {
            cachedServicePublicKey = loadPublicKey(servicePublicRes);
        }
        return cachedServicePublicKey;
    }


    public PublicKey getTrustedPublicKey(String issuer) {
        return cachedTrustedKeys.computeIfAbsent(issuer, iss -> {
            Resource res = trustedServiceKeys.get(iss);
            try {
                return loadPublicKey(res);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private PrivateKey loadPrivateKey(Resource res) throws Exception {
        String key = new String(res.getInputStream().readAllBytes());
        key = key.replaceAll("-----\\w+ PRIVATE KEY-----", "")
                .replaceAll("\\s", "");
        byte[] decoded = Base64.getDecoder().decode(key);
        return KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(decoded));
    }

    private PublicKey loadPublicKey(Resource res) throws Exception {
        String key = new String(res.getInputStream().readAllBytes());
        key = key.replaceAll("-----BEGIN PUBLIC KEY-----", "")
                .replaceAll("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");
        byte[] decoded = Base64.getDecoder().decode(key);
        return KeyFactory.getInstance("RSA")
                .generatePublic(new X509EncodedKeySpec(decoded));
    }

}
