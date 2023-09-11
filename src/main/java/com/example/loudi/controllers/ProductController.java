package com.example.loudi.controllers;

import com.example.loudi.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String products() {
        return "products";
    }
    @GetMapping("/nicita")
    public String product() {
        return "productNicita";
    }
}
