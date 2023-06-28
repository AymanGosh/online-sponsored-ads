package com.adstracker.onlinesponsoredads.service;

import com.adstracker.onlinesponsoredads.model.entity.Campaign;
import com.adstracker.onlinesponsoredads.model.entity.Product;
import com.adstracker.onlinesponsoredads.repository.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampaignService {


   @Autowired
   private CampaignRepo campaignRepo;

    @Autowired
    private ProductService productsService;


    public Campaign getCampaignById(Integer campaignId){
        return campaignRepo.findById(campaignId).get();
    }
    public List<Campaign> getAllCampaigns(){
        return campaignRepo.findAll();
    }

    public Campaign saveCampaign(Campaign campaign) {
        Campaign newCampaign = new Campaign();
        newCampaign.setCampaignName(campaign.getCampaignName());
        newCampaign.setBid(campaign.getBid());
        newCampaign.setStartDate(campaign.getStartDate());
        newCampaign.getProducts()
                .addAll(campaign
                        .getProducts()
                        .stream()
                        .map(v -> {
                            Product vv = productsService.findProductById(v.getProductId());
                            vv.getCampaigns().add(newCampaign);
                            return vv;
                        }).collect(Collectors.toList()));
        return campaignRepo.save(newCampaign);
    }

    public  Product serveAd(String category) {
        List<Campaign> activeCampaigns= getActiveCampaigns();
        if (activeCampaigns.isEmpty()) {
            Campaign highestBidCampaign = getHighestBidCampaign(campaignRepo.findAll());
            Product promotedProduct = highestBidCampaign.getProducts().stream().findFirst().orElse(new Product());
            return promotedProduct;
        }

        List<Campaign> campaignsWithMatchingCategory = activeCampaigns.stream()
                .filter(campaign -> campaign.getProducts().stream()
                        .anyMatch(product -> product.getProductCategory().equals(category)))
                .collect(Collectors.toList());

        Campaign highestBidCampaign = getHighestBidCampaign(campaignsWithMatchingCategory);
        Product promotedProduct = highestBidCampaign.getProducts().stream().filter(p->p.getProductCategory().equals(category)).findFirst().orElse(new Product());
        return promotedProduct;
    }
    public List<Campaign> getActiveCampaigns(){
        var campaignActiveDays =10;
        Date startDate = convertToDateViaSqlDate(LocalDate.now());
        Date endDate = convertToDateViaSqlDate(LocalDate.now().plusDays(campaignActiveDays));
        return campaignRepo.findByStartDateBetween(startDate,endDate);
    }
    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    private Campaign getHighestBidCampaign(List<Campaign> campaigns) {
        if(campaigns.isEmpty()) return new Campaign();
        return Collections.max(campaigns, Comparator.comparingDouble(Campaign::getBid));
    }
}
