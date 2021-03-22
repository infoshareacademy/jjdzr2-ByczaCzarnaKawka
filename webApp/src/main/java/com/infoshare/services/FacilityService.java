package com.infoshare.services;

import domain.activities.SportDisciplines;
import domain.location.Town;
import domain.workoutPlaces.SportFacility;
import org.springframework.stereotype.Service;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
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
    public List<Town> getTownName() {
        return Arrays.asList(Town.values());
    }
    public List<SportDisciplines> getSportDiscipline() {
        return Arrays.asList(SportDisciplines.values());
    }


    public List<SportFacility> findSportFacility(){
        List<SportFacility> facilityList=new ArrayList<>();
        return facilityList;
    }
}
