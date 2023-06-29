package com.adstracker.onlinesponsoredads.controller;

import com.adstracker.onlinesponsoredads.model.entity.Product;
import com.adstracker.onlinesponsoredads.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity(productService.getAll(), HttpStatus.OK );
    }
    @PostMapping
    public ResponseEntity<Product> saveNewProduct(@RequestBody Product newProduct){
        return new ResponseEntity(productService.saveNewProduct(newProduct),HttpStatus.CREATED);
    }
}
