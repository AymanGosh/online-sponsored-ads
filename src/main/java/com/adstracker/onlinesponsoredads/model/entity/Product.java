package com.adstracker.onlinesponsoredads.model.entity;

import com.adstracker.onlinesponsoredads.model.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Objects;

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
    @Column(name="product_category")
    private String productCategory;
    @Column(name="product_price")
    private Double productPrice;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "campaign_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "campaign_id")
    )
    @JsonIgnore
    private List<Campaign> campaigns;
    public static Product DtoToEntity(ProductDto productDto){
        return Product.builder().
                productId(productDto.getProductId()).
                productName(productDto.getProductName()).
                productCategory(productDto.getProductCategory()).
                productPrice(productDto.getProductPrice()).
                campaigns(productDto.getCampaigns()).
                build();
    }
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public List<Campaign> getCampaigns() {
        return campaigns;
    }
    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }
    public String getProductCategory() {
        return productCategory;
    }
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
    public Double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) && Objects.equals(productName, product.productName) && Objects.equals(productCategory, product.productCategory) && Objects.equals(productPrice, product.productPrice) && Objects.equals(campaigns, product.campaigns);
    }
    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productCategory, productPrice, campaigns);
    }
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productPrice=" + productPrice +
                ", campaigns=" + campaigns +
                '}';
    }
}
