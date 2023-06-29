package com.adstracker.onlinesponsoredads.controller;


import com.adstracker.onlinesponsoredads.model.entity.Product;
import com.adstracker.onlinesponsoredads.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAll(){
        return productService.getAll();
    }

    @PostMapping("/save-product")
    public Product saveNewProduct(@RequestBody Product newProduct){
        return productService.saveNewProduct(newProduct);
    }

}
