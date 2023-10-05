package com.example.loudi.services;

import com.example.loudi.models.Image;
import com.example.loudi.models.Product;
import com.example.loudi.models.User;
import com.example.loudi.repositories.ProductRepositori;
import com.example.loudi.repositories.UserRepositori;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepositori productRepositori;
    private final UserRepositori userRepositori;
    public List<Product> listProducts(String title){
        if (title != null) return productRepositori.findByTitle(title);
        return productRepositori.findAll();
    }
    public void saveProduct(Principal principal, Product product, MultipartFile... files) throws IOException {
        User user = getProductByPrincipal(principal);
        product.setUser(user);

        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            if (file.getSize() != 0) {
                Image image = toImageEntity(file);
                if (i == 0) {
                    image.setPreviewImage(true);
                }
                product.addImageToProduct(image);
            }
        }

        log.info("Saving new Product. Title: {}; Author: {}", product.getTitle(), user.getEmail());
        Product savedProduct = productRepositori.save(product);

        if (!savedProduct.getImages().isEmpty()) {
            savedProduct.setPreviewImageId(savedProduct.getImages().get(0).getId());
            productRepositori.save(savedProduct);
        }
    }


    public User getProductByPrincipal(Principal principal) {
        if(principal == null) return new User();
        return userRepositori.findByEmail(principal.getName());
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteProdurct(Long id){
        productRepositori.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepositori.findById(id).orElse(null);
    }
}
