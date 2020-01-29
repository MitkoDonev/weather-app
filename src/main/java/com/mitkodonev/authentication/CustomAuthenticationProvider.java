package com.mitkodonev.authentication;

import com.mitkodonev.entity.User;
import com.mitkodonev.repository.UserRepository;
import com.mitkodonev.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private UserRepository userRepository;

    @Autowired
    public CustomAuthenticationProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (name != null) {
            User user = userRepository.findByUsername(name);
            if (user != null && user.getPassword() != null) {
                if (user.getPassword().equals(password)) {
                    return new UsernamePasswordAuthenticationToken(
                            name, password, new ArrayList<>());
                }
            }
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}