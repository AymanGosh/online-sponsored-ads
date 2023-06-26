package com.adstracker.onlinesponsoredads.model.entity;


import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Table(name="campaigns")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CampaignEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="campaign_id")
    private Integer campaignId;
    @Column(name="campaign_name")
    private String campaignName;

    @ManyToMany
    @JoinTable(
            name="campaign_product",
            joinColumns = @JoinColumn(name="campaign_id"),
            inverseJoinColumns=@JoinColumn(name="product_id")
    )
    private List<Product> products;

}
