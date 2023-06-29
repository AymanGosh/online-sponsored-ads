package com.adstracker.onlinesponsoredads.model.dto;

import com.adstracker.onlinesponsoredads.model.entity.Campaign;
import com.adstracker.onlinesponsoredads.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Integer productId;
    private String productName;
    private String productCategory;
    private Double productPrice;
    private List<Campaign> campaigns;
    public static ProductDto fromEntityToDto(Product productEntity){
        return ProductDto.builder().
                productId(productEntity.getProductId()).
                productName(productEntity.getProductName()).
                productCategory(productEntity.getProductCategory()).
                productPrice(productEntity.getProductPrice()).
                campaigns(productEntity.getCampaigns()).
                build();
    }
    public static List<ProductDto> fromEntityToDto(List<Product> productsEntity){
        List<ProductDto> listOfProductsDto = new ArrayList<>();
        listOfProductsDto.addAll(productsEntity.stream().map(pe->ProductDto.fromEntityToDto(pe)).collect(Collectors.toList()));
        return listOfProductsDto;
    }
}
