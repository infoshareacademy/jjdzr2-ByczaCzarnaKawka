package com.infoshare.dao;

import com.infoshare.workoutPlaces.SportFacility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.infoshare.utils.FileUtils.readSportsFacilities;

public class FacilityRepository {

    private Map<Integer, SportFacility> facilityMap;

    public FacilityRepository() {
        this.facilityMap = new HashMap<>();
        prepareData();
    }

    public Map<Integer, SportFacility> getFacilityMap() {
        return facilityMap;
    }

    private void prepareData() {
        List<SportFacility> sportFacilityList = readSportsFacilities();
        for (SportFacility sportFacility : sportFacilityList) {
            facilityMap.put(sportFacility.getOrdinalNumber(), sportFacility);
        }
    }
}
