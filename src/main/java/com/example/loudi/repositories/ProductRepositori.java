package com.example.loudi.repositories;

import com.example.loudi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepositori extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
}
