package com.example.loudi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/")
    public String main() {
        return "products";
    }
    @GetMapping("/nicita")
    public String product() {
        return "productNicita";
    }
}
