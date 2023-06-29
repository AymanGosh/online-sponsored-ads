package com.adstracker.onlinesponsoredads.model.entity;

import com.adstracker.onlinesponsoredads.model.dto.CampaignDto;
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
    public static Campaign DtoToEntity(CampaignDto campaignDto){
        return Campaign.builder().
                campaignId(campaignDto.getCampaignId()).
                campaignName(campaignDto.getCampaignName()).
                startDate(campaignDto.getStartDate()).
                bid(campaignDto.getBid()).
                products(campaignDto.getProducts()).
                build();
    }
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(campaignId, campaign.campaignId) && Objects.equals(campaignName, campaign.campaignName) && Objects.equals(startDate, campaign.startDate) && Objects.equals(bid, campaign.bid) && Objects.equals(products, campaign.products);
    }
    @Override
    public int hashCode() {
        return Objects.hash(campaignId, campaignName, startDate, bid, products);
    }
    @Override
    public String toString() {
        return "Campaign{" +
                "campaignId=" + campaignId +
                ", campaignName='" + campaignName + '\'' +
                ", startDate=" + startDate +
                ", bid=" + bid +
                ", products=" + products +
                '}';
    }
}
