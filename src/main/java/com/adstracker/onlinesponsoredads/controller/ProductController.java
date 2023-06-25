package com.adstracker.onlinesponsoredads.controller;


import com.adstracker.onlinesponsoredads.model.entity.Product;
import com.adstracker.onlinesponsoredads.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/get-product")
    public Product getProductById(@RequestParam Integer productId){
        return productService.getProduct(productId);
    }
}
