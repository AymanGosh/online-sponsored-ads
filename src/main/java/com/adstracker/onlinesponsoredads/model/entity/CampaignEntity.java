package com.adstracker.onlinesponsoredads.model.entity;


import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
}
