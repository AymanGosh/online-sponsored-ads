package com.adstracker.onlinesponsoredads.service;

import com.adstracker.onlinesponsoredads.model.entity.CampaignEntity;
import com.adstracker.onlinesponsoredads.repository.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepo campaignRepo;

    public CampaignEntity getCampaignById(Integer campaignId){
        return campaignRepo.findById(campaignId).get();
    }
}
