package com.example.demo.config;

import java.util.*;

import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.User;


public class CustomUserDetails implements UserDetails {

    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> user.getRole()); // USER / ADMIN
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override 
    public boolean isAccountNonExpired() { 
    	return true;
    }
    @Override 
    public boolean isAccountNonLocked() { 
    	return true; 
    }
    @Override 
    public boolean isCredentialsNonExpired() { 
    	return true; 
    }
    @Override 
    public boolean isEnabled() { 
    	return true; 
    }
}