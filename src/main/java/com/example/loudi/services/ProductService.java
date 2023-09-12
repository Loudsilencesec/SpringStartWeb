package com.example.loudi.services;

import com.example.loudi.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID ,"PS5", "Simpel", 67000, "Krasnoyrsk", "Sony"));
        products.add(new Product(++ID ,"Imphone 9", "Deckription", 90000, "Moskov", "Apple"));
    }

    public List<Product> listProducts(){
        return products;
    }
    public void saveProduct(Product product){
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProdurct(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}
