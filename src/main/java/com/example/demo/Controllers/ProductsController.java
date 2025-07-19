package com.example.demo.Controllers;

import com.example.demo.Entity.Products;
import com.example.demo.Service.ProductsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping
    public List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }

    @PostMapping
    public Products addProduct(@RequestBody Products products) {
        return  productsService.addProduct(products);
    }
}
