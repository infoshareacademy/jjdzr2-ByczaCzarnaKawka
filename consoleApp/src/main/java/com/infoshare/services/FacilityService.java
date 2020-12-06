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
