package com.adstracker.onlinesponsoredads.controller;


import com.adstracker.onlinesponsoredads.model.dto.ProductDto;
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
    public List<ProductDto> getAll(){
        return productService.getAll();
    }

    @GetMapping("/get-product")
    public ProductDto getProductById(@RequestParam Integer productId){
        return productService.getProduct(productId);
    }

    @PostMapping("/save-product")
    public ProductDto saveNewProduct(@RequestBody ProductDto newProduct){
        return productService.saveNewProduct(newProduct);
    }

}
