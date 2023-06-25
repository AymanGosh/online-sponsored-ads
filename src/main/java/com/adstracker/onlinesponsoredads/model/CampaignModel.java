package com.adstracker.onlinesponsoredads.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CampaignModel {

    List<String> names= new ArrayList<>();

    CampaignModel(){
        names.add("Black Friday");
        names.add("Ramdan");
    }
    public String getCampaignFromDB(){

        return names.get(0);
    }
}
