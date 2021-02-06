package com.infoshare.services;

import domain.workoutPlaces.SportFacility;
import org.springframework.stereotype.Service;
import utils.FileUtils;

import java.util.List;

@Service
public class FacilityService {

    private List<SportFacility> sportFacilityList;

    public FacilityService(){
        prepareData();
    }

    public List<SportFacility> getSportFacilityList() {
        return sportFacilityList;
    }

    private void prepareData(){
        sportFacilityList = FileUtils.readSportsFacilities();
    }

}
