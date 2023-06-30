package com.adstracker.onlinesponsoredads.model.dto;

import com.adstracker.onlinesponsoredads.model.entity.Campaign;
import com.adstracker.onlinesponsoredads.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignDto {
    private Integer campaignId;
    private String campaignName;
    private Date startDate;
    private Double bid;
    private Collection<Product> products = new ArrayList<>();
    public static CampaignDto fromEntityToDto(Campaign campaignEntity){
        return CampaignDto.builder().
                campaignId(campaignEntity.getCampaignId()).
                campaignName(campaignEntity.getCampaignName()).
                startDate(campaignEntity.getStartDate()).
                bid(campaignEntity.getBid()).
                products(campaignEntity.getProducts()).
                build();
    }
    public static List<CampaignDto> fromEntityToDto(List<Campaign> campaignsEntity){
        List<CampaignDto> listOfCampaignsDto = new ArrayList<>();
        listOfCampaignsDto.addAll(campaignsEntity.stream().map(ce->CampaignDto.fromEntityToDto(ce)).collect(Collectors.toList()));
        return listOfCampaignsDto;
    }
}