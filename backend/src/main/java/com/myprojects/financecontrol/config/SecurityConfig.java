package com.myprojects.financecontrol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    

    // This configuration disables CSRF protection and allows unrestricted access to all endpoints.
    // It's advisable to restrict access to sensitive endpoints based on roles or authentication status.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); 
        return http.build();
    } 
}