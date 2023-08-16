package com.example.api.controllers;

import com.example.api.entities.Product;
import com.example.api.services.ProductService;
import com.example.api.token.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(@RequestHeader("Token") String token) {

        JwtTokenService tokenService = new JwtTokenService();
        boolean isValidToken = tokenService.validateToken(token);

        if (isValidToken) {
            return productService.getProducts();
        } else {
            return null;
        }
    }
}