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

    @Column(name="campaign_start_date")
    private Date startDate;

    @Column(name="campaign_bid")
    private Double bid;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }
}
