package com.adstracker.onlinesponsoredads.service;

import com.adstracker.onlinesponsoredads.model.entity.Campaign;
import com.adstracker.onlinesponsoredads.model.entity.Product;
import com.adstracker.onlinesponsoredads.repository.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
