package com.example.loudi.services;

import com.example.loudi.models.Product;
import com.example.loudi.repositories.ProductRepositori;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepositori productRepositori;
    public List<Product> listProducts(String title){
        if (title != null) productRepositori.findByTitle(title);
        return productRepositori.findAll();
    }
    public void saveProduct(Product product){
        log.info("Saving new {}", product);
        productRepositori.save(product);
    }

    public void deleteProdurct(Long id){
        productRepositori.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepositori.findById(id).orElse(null);
    }
}
