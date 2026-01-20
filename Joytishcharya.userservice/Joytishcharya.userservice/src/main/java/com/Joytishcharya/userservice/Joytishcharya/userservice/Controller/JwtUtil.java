package com.Joytishcharya.userservice.Joytishcharya.userservice.Controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.bouncycastle.jcajce.BCFKSLoadStoreParameter;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component

public class JwtUtil {

    private static final String SECRET =
            "my-super-secret-key-my-super-secret-key-123456"; // ≥32 chars

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)
                )
                .signWith(key, SignatureAlgorithm.HS256) // ✅ CORRECT
                .compact();
    }
}
