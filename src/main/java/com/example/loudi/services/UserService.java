package com.example.loudi.services;

import com.example.loudi.models.User;
import com.example.loudi.models.enums.Role;
import com.example.loudi.repositories.UserRepositori;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor

public class UserService {
    private final UserRepositori userRepositori;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user){
        String email = user.getEmail();
        if (userRepositori.findByEmail(email) != null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        log.info("Saving new User with email: {}", email);
        userRepositori.save(user);
        return true;
    }
    public List<User> list() {
        return userRepositori.findAll();
    }

    public void banUser(Long id) {
        User user = userRepositori.findById(id).orElse(null);
        if (user != null){
            if (user.isActive()){
                user.setActive(false);
                log.info("Заблокирован пользователь  с id = {}; email: {}", user.getId(), user.getEmail());
            } else{
                user.setActive(true);
                log.info("Пользователь разблокирован  с id = {}; email: {}", user.getId(), user.getEmail());
            }
            userRepositori.save(user);
        }
    }

    public void changeUserRoles(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepositori.save(user);
    }

}
