package com.sm7.rzrv.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JWTGenerator {

    @Value("${JWT_EXPIRATION}")
    private String jwt_expiration;

    @Value("${JWT_SECRET}")
    private String jwt_secret;
    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + Long.parseLong(jwt_expiration));

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, jwt_secret)
                .compact();
        return token;
    }

    public String decodeUserToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(jwt_secret)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(jwt_secret).build().parseSignedClaims(token);
            return true;
        }catch(Exception e){
            throw new AuthenticationCredentialsNotFoundException("Jwt Expired or incorrect");
        }
    }
}
