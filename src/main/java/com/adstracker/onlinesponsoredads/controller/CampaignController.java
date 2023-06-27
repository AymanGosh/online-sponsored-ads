package com.adstracker.onlinesponsoredads.controller;


import com.adstracker.onlinesponsoredads.model.entity.Campaign;
import com.adstracker.onlinesponsoredads.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {
    @Autowired
    private CampaignService campaignService; // bean
    @GetMapping("get-campaign")
    public Campaign getCampaignById(@RequestParam Integer campaignId){
        return  campaignService.getCampaignById(campaignId);
    }
    @GetMapping()
    public List<Campaign> getAllCampaigns(){
        return  campaignService.getAllCampaigns();
    }



    @PostMapping
    public String saveCampaign(@RequestBody Campaign campaign) {
        campaignService.saveCampaign(campaign);
        return("OK");
    }
}
