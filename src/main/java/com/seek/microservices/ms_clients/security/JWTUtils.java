package com.seek.microservices.ms_clients.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JWTUtils {

    private final String SECRET = "b205cbcbed3aa08c25c4cc051840569f023a571b7f74c1c8b6f0dd94bf12f0d17535103c587f2e2cd9e263ca1b93253d7cb955c00d57a97b1087666ca947874bf09073947cf0a1e28f5a21d7603006a9265349d3cccb89884d262f6be415e24df61276e1d80dc42e3f8d66f48a043c565e33a6bee0657a57d164aedfde8cacf5b66739d8be9b0f1789affb7087f088a1b54d37277305444f0fd8d53dda97dc3ba82ee15a8f45615ff43c5b1a8a7c8fc27d976d6d8de9784445f8871176b84a5054360dffbd586d2aeaf635f5a5427e9ce0d37ed6b46f9c63795371d1b221369afba969df39e88be212bc031ce36be185d9c69f9e9eec8f6bdde34d794dd2f952";

    private final long EXPIRATION_MS = 1200000; // 1 minute

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
