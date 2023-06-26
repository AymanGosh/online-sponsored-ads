package com.adstracker.onlinesponsoredads.controller;


import com.adstracker.onlinesponsoredads.model.entity.CampaignEntity;
import com.adstracker.onlinesponsoredads.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {
    @Autowired
    private CampaignService campaignService; // bean
    @GetMapping("get-campaign")
    public CampaignEntity getCampaignById(@RequestParam Integer campaignId){
        return  campaignService.getCampaignById(campaignId);
    }
}
 