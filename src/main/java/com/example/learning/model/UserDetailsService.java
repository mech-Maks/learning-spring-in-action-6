package com.example.learning.model;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
    // searches for user by userName
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
