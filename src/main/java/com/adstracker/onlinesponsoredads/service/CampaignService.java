package com.adstracker.onlinesponsoredads.service;

import com.adstracker.onlinesponsoredads.model.CampaignModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {

    @Autowired
    private CampaignModel campaignmodel;
    public String getCampaignName(String name){
        String n =  campaignmodel.getCampaignFromDB();
        return n.toUpperCase() + name;
    }
}
