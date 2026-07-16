package com.vintagevault.security;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



@Configuration
public class SecurityConfig {


    private final JwtAuthenticationFilter jwtAuthenticationFilter;



    public SecurityConfig(
            JwtAuthenticationFilter jwtAuthenticationFilter) {

        this.jwtAuthenticationFilter = jwtAuthenticationFilter;

    }





    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {


        http

            .csrf(csrf -> csrf.disable())


            .cors(cors ->
                cors.configurationSource(
                        corsConfigurationSource()
                )
            )


            .authorizeHttpRequests(auth -> auth



                // Login and Register
                .requestMatchers(
                        "/api/auth/**"
                )
                .permitAll()



                // Product APIs
                .requestMatchers(
                        "/api/products/**"
                )
                .permitAll()



                // Swagger
                .requestMatchers(
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html"
                )
                .permitAll()



                // Cart
                .requestMatchers(
                        "/api/cart/**"
                )
                .hasRole("BUYER")



                // Orders
                .requestMatchers(
                        "/api/orders/**"
                )
                .hasRole("BUYER")



                // Wishlist
                .requestMatchers(
                        "/api/wishlist/**"
                )
                .hasRole("BUYER")



                // Seller
                .requestMatchers(
                        "/api/seller/**"
                )
                .hasRole("SELLER")



                // Admin
                .requestMatchers(
                        "/api/admin/**"
                )
                .hasRole("ADMIN")



                .anyRequest()
                .authenticated()

            )



            .sessionManagement(session ->
                session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS
                )
            )



            .addFilterBefore(
                    jwtAuthenticationFilter,
                    UsernamePasswordAuthenticationFilter.class
            );



        return http.build();

    }






    @Bean
    public CorsConfigurationSource corsConfigurationSource() {


        CorsConfiguration configuration =
                new CorsConfiguration();



        configuration.setAllowedOrigins(
                List.of(
                        "http://localhost:5173",
                        "http://localhost:5174",
                        "http://localhost:5176"
                )
        );



        configuration.setAllowedMethods(
                List.of(
                        "GET",
                        "POST",
                        "PUT",
                        "DELETE",
                        "OPTIONS"
                )
        );



        configuration.setAllowedHeaders(
                List.of("*")
        );



        configuration.setAllowCredentials(true);



        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();



        source.registerCorsConfiguration(
                "/**",
                configuration
        );



        return source;

    }







    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }







    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration)
            throws Exception {


        return configuration.getAuthenticationManager();

    }


}