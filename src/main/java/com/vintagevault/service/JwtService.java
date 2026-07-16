package com.vintagevault.service;

import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {


    private final String SECRET_KEY =
            "VintageVaultSecretKeyForAuthenticationSystem2026Secure";


    private SecretKey getSigningKey(){

        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes()
        );

    }



    // Generate token after successful login

    public String generateToken(
            String email,
            String role
    ){

        return Jwts.builder()

                .subject(email)

                .claim(
                    "role",
                    role
                )

                .issuedAt(
                    new Date()
                )

                .expiration(
                    new Date(
                        System.currentTimeMillis()
                        + 1000 * 60 * 60 * 24
                    )
                )

                .signWith(
                    getSigningKey()
                )

                .compact();

    }




    // Extract email from token

    public String extractUsername(
            String token
    ){

        Claims claims =
                Jwts.parser()

                .verifyWith(
                    getSigningKey()
                )

                .build()

                .parseSignedClaims(token)

                .getPayload();


        return claims.getSubject();

    }





    // Validate token

    public boolean validateToken(
            String token
    ){

        try{

            Jwts.parser()

            .verifyWith(
                getSigningKey()
            )

            .build()

            .parseSignedClaims(token);


            return true;

        }

        catch(Exception e){

            return false;

        }

    }





    // Get user role from token

    public List<SimpleGrantedAuthority> getAuthorities(
            String token
    ){

        Claims claims =
                Jwts.parser()

                .verifyWith(
                    getSigningKey()
                )

                .build()

                .parseSignedClaims(token)

                .getPayload();



        String role =
                claims.get("role", String.class);



        return List.of(
                new SimpleGrantedAuthority(
                        "ROLE_" + role
                )
        );

    }

}