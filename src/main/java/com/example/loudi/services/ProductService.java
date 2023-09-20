package com.example.loudi.services;

import com.example.loudi.models.Image;
import com.example.loudi.models.Product;
import com.example.loudi.repositories.ProductRepositori;
import jakarta.mail.Multipart;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepositori productRepositori;
    public List<Product> listProducts(String title){
        if (title != null) return productRepositori.findByTitle(title);
        return productRepositori.findAll();
    }
    public void saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0){
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
        if (file2.getSize() != 0){
            image2 = toImageEntity(file2);
            product.addImageToProduct(image2);
        }
        if (file3.getSize() != 0){
            image3 = toImageEntity(file3);
            product.addImageToProduct(image3);
        }
        log.info("Saving new Prodect. Title: {}; Author: {}", product.getTitle(), product.getAuthor());
        Product productFromDb = productRepositori.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        productRepositori.save(product);
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
