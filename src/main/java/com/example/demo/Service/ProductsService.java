package com.example.demo.Service;

import com.example.demo.Entity.Products;
import com.example.demo.Repository.ProductsRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    public Products addProduct(Products products) {
        return productsRepository.save(products);
    }
}
