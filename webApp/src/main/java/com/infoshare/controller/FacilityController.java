package com.infoshare.controller;

import com.infoshare.services.FacilityService;
import domain.workoutPlaces.SportFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FacilityController {

    private final FacilityService facilityService;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping("/facilities/all")
    @ResponseBody
    public String getAllFacilityList(){
        List<SportFacility> actualList = facilityService.getSportFacilityList();
        List<String> listOfString = actualList.stream().map(SportFacility::toString).collect(Collectors.toList());
        String string = String.join("\n \n", listOfString);
        return string;
    }
}
