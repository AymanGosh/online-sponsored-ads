package com.adstracker.onlinesponsoredads.repository;

import com.adstracker.onlinesponsoredads.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepo extends JpaRepository<Product,Integer> {
    Product findByProductId(Integer productId);
}
