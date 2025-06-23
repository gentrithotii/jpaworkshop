package com.example.jpaworkshop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Import for password encoder
import org.springframework.security.crypto.password.PasswordEncoder; // Import for password encoder

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity // This annotation is usually implicitly added by Spring Boot if SecurityAutoConfiguration is on classpath
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Or another suitable encoder
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("gentrithotii")
                .password(passwordEncoder.encode("1234")) // Encode the password!
                .roles("USER") // Assign roles if needed
                .build();
        // You can add more users here if necessary
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for Postman during development (be cautious in production)
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().authenticated() // Require authentication for all requests
                )
                .httpBasic(withDefaults()); // Enable HTTP Basic authentication

        return http.build();
    }
}
