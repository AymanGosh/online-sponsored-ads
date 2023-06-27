package com.adstracker.onlinesponsoredads.repository;

import com.adstracker.onlinesponsoredads.model.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepo extends JpaRepository<Campaign,Integer> {
    Campaign findByCampaignId(Integer campaignId);
}
