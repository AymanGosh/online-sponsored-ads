package com.adstracker.onlinesponsoredads.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Campaignmodel {

    List<String> names= new ArrayList<>();

    Campaignmodel(){
        names.add("Black Friday");
        names.add("Ramdan");
    }
    public String getCampaignFromDB(){

        return names.get(0);
    }
}
