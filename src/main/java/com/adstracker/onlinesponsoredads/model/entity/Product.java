package com.adstracker.onlinesponsoredads.model.entity;

import com.adstracker.onlinesponsoredads.model.dto.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="products")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="product_id")
    private Integer productId;
    @Column(name="product_name")
    private String productName;

    public static Product DtoToEntity(ProductDto productDto){
        return Product.builder().
                productName(productDto.getProductName()).
                build();
    }


}
