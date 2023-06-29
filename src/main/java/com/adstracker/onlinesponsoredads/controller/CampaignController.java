package com.adstracker.onlinesponsoredads.controller;

import com.adstracker.onlinesponsoredads.model.dto.CampaignDto;
import com.adstracker.onlinesponsoredads.model.dto.ProductDto;
import com.adstracker.onlinesponsoredads.model.entity.Campaign;
import com.adstracker.onlinesponsoredads.model.entity.Product;
import com.adstracker.onlinesponsoredads.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;
    @GetMapping()
    public ResponseEntity<List<CampaignDto>> getAllCampaigns(){
        return  new ResponseEntity (CampaignDto.fromEntityToDto(campaignService.getAllCampaigns()),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Campaign> saveCampaign(@RequestBody CampaignDto campaign) {
        return new ResponseEntity (campaignService.saveCampaign(Campaign.DtoToEntity(campaign)),HttpStatus.CREATED);
    }
    @GetMapping("/serve-ad")
    public ResponseEntity<?> serveAd(@RequestParam("category") String category) {
        Product promotedProduct=campaignService.serveAd(category);
        if(promotedProduct.getProductName()==null) return   ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serve Ad not found, make sure there are campaigns.");
        return new ResponseEntity(ProductDto.fromEntityToDto(promotedProduct), HttpStatus.OK);
    }
}
