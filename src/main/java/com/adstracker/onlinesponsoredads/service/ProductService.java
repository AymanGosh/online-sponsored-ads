package com.adstracker.onlinesponsoredads.service;

import com.adstracker.onlinesponsoredads.model.dto.ProductDto;
import com.adstracker.onlinesponsoredads.model.entity.Product;
import com.adstracker.onlinesponsoredads.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public ProductDto getProduct(Integer productId){
        Optional<Product> product = this.productRepo.findById(productId);
        if(product.isPresent()){
            return ProductDto.fromEntityToDto(product.get());
        }
        else
            return ProductDto.fromEntityToDto(new Product());
        //return product.orElse(new Product());
    }

    public ProductDto saveNewProduct(ProductDto newProduct){
        //ToDo : validation the income data
        Product product=this.productRepo.save(Product.DtoToEntity(newProduct));
        return ProductDto.fromEntityToDto(product);
    }
    public List<ProductDto> getAll(){

        System.out.println(  this.productRepo.findAll());

        //List<Product> ProductsEntitiy = (List<Product>) productRepo.findAll();
        List<Product> ProductsEntitiy = productRepo.findAll();
        List<ProductDto> converted = new ArrayList<ProductDto>();

        for (Product pe : ProductsEntitiy) {
            ProductDto dto =ProductDto.fromEntityToDto(pe);
            converted.add(dto);
        }
        return converted;

    }

}
