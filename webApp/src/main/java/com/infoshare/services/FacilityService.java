package com.infoshare.services;

import domain.activities.SportDisciplines;
import domain.location.Town;
import domain.workoutPlaces.SportFacility;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacilityService {

    private List<SportFacility> sportFacilityList;

    public FacilityService() {
        prepareData();
    }

    public List<SportFacility> getSportFacilityList() {
        return sportFacilityList;
    }

    private void prepareData() {
        sportFacilityList = FileUtils.readSportsFacilities();
    }

    public List<Town> getTownName() {
        return Arrays.asList(Town.values());
    }

    public List<SportDisciplines> getSportDiscipline() {
        return Arrays.asList(SportDisciplines.values());
    }

    public List<SportFacility> findSportFacility(String town, String sportDisciplines, String club) {
        prepareData();
        List<SportFacility> tempFacilityList = getSportFacilityList();

        if(!town.equals("ALL")){
            tempFacilityList=tempFacilityList.stream()
                    .filter(sportFacility -> sportFacility.getAddress().getTownName().toString().equals(town))
                    .collect(Collectors.toList());
        }
        if(!sportDisciplines.equals("ALL")){
            tempFacilityList=tempFacilityList.stream()
                    .filter(sportFacility -> sportFacility.getDiscipline().toString().equals(sportDisciplines))
                    .collect(Collectors.toList());
        }
        if(!club.equals("ALL")){
            tempFacilityList=tempFacilityList.stream()
                    .filter(sportFacility -> sportFacility.getName().toLowerCase().contains(club.toLowerCase()))
                    .collect(Collectors.toList());
        }

        System.out.println(tempFacilityList);



//        List<SportFacility> temp = getSportFacilityList().stream()
//                .filter(sportFacility -> sportFacility.getAddress().getTownName().toString().equals(town))
//                .filter(sportFacility -> sportFacility.getName().contains(club))
////    //TODO more filters - sportDiscipline and date
//                .collect(Collectors.toList());

        return tempFacilityList;
    }
}
