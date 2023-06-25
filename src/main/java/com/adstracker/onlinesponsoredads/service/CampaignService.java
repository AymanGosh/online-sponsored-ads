package com.adstracker.onlinesponsoredads.service;

import com.adstracker.onlinesponsoredads.model.Campaignmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {

    @Autowired
    private Campaignmodel campaignmodel;
    public String getCampaignName(String name){
        String n =  campaignmodel.getCampaignFromDB();
        return n.toUpperCase() + name;
    }
}
