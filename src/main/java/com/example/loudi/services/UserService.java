package com.example.loudi.services;

import com.example.loudi.models.User;
import com.example.loudi.models.enums.Role;
import com.example.loudi.repositories.UserRepositori;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class UserService {
    private final UserRepositori userRepositori;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user){
        String email = user.getEmail();
        if (userRepositori.findByEmail(email) != null) return false;
        user.setAcrive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        log.info("Saving new User with email: {}", email);
        userRepositori.save(user);
        return true;
    }
}
