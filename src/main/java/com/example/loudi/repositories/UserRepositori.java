package com.example.loudi.repositories;

import com.example.loudi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositori extends JpaRepository<User, Long> {
    User findByEmail(String name);

}
