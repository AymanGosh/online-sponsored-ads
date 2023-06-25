package com.adstracker.onlinesponsoredads.controller;


import com.adstracker.onlinesponsoredads.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class CampaignController {
    @Autowired
    private CampaignService campaignService; // bean

    // autowired its like :
    //private CampaignService campaignService;
    //public CampaignService(CampaignService campaignService){
    // this.campaignService=campaignService;
    //}
    @GetMapping("/campaign")
    public String getCampaignName(){
        System.out.println("black friday");
        return  campaignService.getCampaignName("Ramdan");
    }
}
