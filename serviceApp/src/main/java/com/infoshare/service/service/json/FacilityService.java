package com.infoshare.service.service.json;

import com.infoshare.service.domain.activities.SportDiscipline;
import com.infoshare.service.domain.location.Town;
import com.infoshare.service.domain.workoutPlace.SportFacility;
import org.springframework.stereotype.Service;
import com.infoshare.service.utils.FileUtils;

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

    public List<SportDiscipline> getSportDiscipline() {
        return Arrays.asList(SportDiscipline.values());
    }

    public List<SportFacility> findSportFacility(String town, String sportDisciplines, String club) {
        prepareData();
        List<SportFacility> tempFacilityList = getSportFacilityList();

        if (!town.equals("ALL")) {
            tempFacilityList = tempFacilityList.stream()
                    .filter(sportFacility -> sportFacility.getAddress().getTownName().toString().equals(town))
                    .collect(Collectors.toList());
        }
        if (!sportDisciplines.equals("ALL")) {
            tempFacilityList = tempFacilityList.stream()
                    .filter(sportFacility -> sportFacility.getDiscipline().toString().equals(sportDisciplines))
                    .collect(Collectors.toList());
        }
        if (!club.equals("ALL")) {
            tempFacilityList = tempFacilityList.stream()
                    .filter(sportFacility -> sportFacility.getName().toLowerCase().contains(club.toLowerCase()))
                    .collect(Collectors.toList());
        }

        return tempFacilityList;
    }
}
