package com.adstracker.onlinesponsoredads.service;

import com.adstracker.onlinesponsoredads.model.entity.Product;
import com.adstracker.onlinesponsoredads.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product getProduct(Integer productId){
        Optional<Product> product = this.productRepo.findById(productId);
//        if(product.isPresent()){
//            product.get();
//        }
//        return new Product();
        return product.orElse(new Product());
    }
}
