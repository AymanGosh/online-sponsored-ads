package com.adstracker.onlinesponsoredads.repository;

import com.adstracker.onlinesponsoredads.model.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface CampaignRepo extends JpaRepository<Campaign,Integer> {
    Campaign findByCampaignId(Integer campaignId);
    List<Campaign> findByStartDateBetween(Date startDate, Date endDate);
}
