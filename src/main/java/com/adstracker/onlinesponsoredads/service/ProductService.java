package com.adstracker.onlinesponsoredads.service;

import com.adstracker.onlinesponsoredads.model.entity.Product;
import com.adstracker.onlinesponsoredads.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

//    public Product getProductById(Integer productId){
//        Optional<Product> product = this.productRepo.findById(productId);
//        if(product.isPresent()){
//            return product.get();
//        }
//        else
//            return new Product();
//        //return product.orElse(new Product());
//    }

    public Product findProductById(Integer productId) {
        return productRepo.findByProductId(productId);
    }
    public List<Product> getAll(){
        return productRepo.findAll();
    }

    public Product saveNewProduct(Product newProduct){
        return productRepo.save(newProduct);
    }


}
