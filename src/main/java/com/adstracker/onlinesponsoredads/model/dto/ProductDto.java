package com.adstracker.onlinesponsoredads.model.dto;


import com.adstracker.onlinesponsoredads.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    //private Integer productId;
    private String productName;
    public static ProductDto fromEntityToDto(Product productEntity){
        return ProductDto.builder().
                //productId(productEntity.getProductId()).
                productName(productEntity.getProductName()).
                build();
    }
}
