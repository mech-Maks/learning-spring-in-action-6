package com.example.learning.configuration.security;

import com.example.learning.entity.User;
import com.example.learning.model.UserDetailsService;
import com.example.learning.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    /*
     * Encrypt password and send it to server (don't decrypt on server-side).
     * Method matches(...) of class PasswordEncoder is used to compare encrypted passwords.
     * Bean is fetched by autoconfiguration of spring security component
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // bean for spring-security to configure rules for url-access
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // DO NOT USE IN PROD
        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http
                .authorizeRequests()
                .antMatchers("/design", "/orders").hasRole("USER")
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/", "/**").permitAll()
                .and()
                .formLogin().loginPage("/login")
                .and()
                .build();
    }
}
