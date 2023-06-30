package com.adstracker.onlinesponsoredads.controller;

import com.adstracker.onlinesponsoredads.model.dto.ProductDto;
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
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return new ResponseEntity( ProductDto.fromEntityToDto(productService.getAllProducts()), HttpStatus.OK );
    }
    @PostMapping
    public ResponseEntity<ProductDto> saveNewProduct(@RequestBody ProductDto newProduct){
        return new ResponseEntity(productService.saveNewProduct(Product.DtoToEntity(newProduct)),HttpStatus.CREATED);
    }
}
