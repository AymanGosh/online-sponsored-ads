package com.adstracker.onlinesponsoredads.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Table(name="campaigns")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="campaign_id")
    private Integer campaignId;
    @Column(name="campaign_name")
    private String campaignName;

//    @ManyToMany(cascade = CascadeType.ALL)
////    @JoinTable(name = "campaign_product",
////            joinColumns = @JoinColumn(name = "campaign_id",referencedColumnName = "campaign_id"),
////            inverseJoinColumns = @JoinColumn(name = "product_id",referencedColumnName = "product_id")
////    )
    @ManyToMany(mappedBy = "campaigns", cascade = CascadeType.ALL)
    private Collection<Product> products = new ArrayList<>();

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
