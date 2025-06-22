package com.skillmentor.root.util;

import com.skillmentor.root.entity.UserEntity;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey jwtSigningKey;

    public JwtUtil(SecretKey jwtSigningKey) {
        this.jwtSigningKey = jwtSigningKey;
    }

    public String generateJWTToken(UserEntity user, String username) {
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + 1000 * 60 * 60; // 1 hour

        return Jwts.builder()
                .subject(String.valueOf(user.getId()))
                .claim("username", username)
                .claim("role", user.getRole().getName())
                .issuedAt(new Date(nowMillis))
                .expiration(new Date(expMillis))
                .signWith(jwtSigningKey, Jwts.SIG.HS256)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(jwtSigningKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            String username = claims.get("username", String.class);
            if (username == null) {
                throw new IllegalArgumentException("Username claim not found in token");
            }
            return username;
        } catch (JwtException e) {
            throw new IllegalArgumentException("Invalid or expired token", e);
        }
    }
}

