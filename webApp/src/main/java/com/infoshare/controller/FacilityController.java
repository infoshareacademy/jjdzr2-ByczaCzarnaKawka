package com.infoshare.controller;

import com.infoshare.services.FacilityService;
import domain.workoutPlaces.SportFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FacilityController {

    private final FacilityService facilityService;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping("/facilities/all")
    public String getAllFacilityList(Model model){
        List<SportFacility> currentFacilitiesList = facilityService.getSportFacilityList();

        if(currentFacilitiesList.isEmpty()){
            String info = "Unfortunately there's no facilities to book, on the list...";
            model.addAttribute(info);
            return "emptyFacilitiesList";
        }else{
            model.addAttribute("facilities", currentFacilitiesList);
            return "allFacilitiesList";
        }

    }
}
