package com.infoshare.services;

import com.infoshare.dao.FacilityRepository;
import com.infoshare.workoutPlaces.SportFacility;

import java.util.Map;

public class FacilityService {

    //TODO add facility filter method, remove method

    private FacilityRepository facilityRepository;

    public FacilityService() {
        this.facilityRepository = new FacilityRepository();
    }

    public void saveFacility(SportFacility facility) {
        Map<Integer, SportFacility> facilityMap = facilityRepository.getFacilityMap();

        if (facilityMap.containsKey(facility.getOrdinalNumber())) {
            System.out.println("Unfortunately the sport facility is already exist!");
        } else {
            facilityMap.put(facility.getOrdinalNumber(), facility);
            System.out.println("Sport facility successfully added to list!");
        }
    }

    public void printFacilityList() {
        Map<Integer, SportFacility> facilityMap = facilityRepository.getFacilityMap();

        System.out.println("-----------");
        System.out.println("FACILITY LIST:");
        System.out.println("----------- \n");

        for (SportFacility facility : facilityMap.values()) {
            System.out.println("<<<<<<<<<<<<<<<<");
            facility.printBasicInfo();
            System.out.println(">>>>>>>>>>>>>>>>\n");
        }
    }
}
