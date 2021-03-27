package com.infoshare.console.services;

import com.infoshare.service.repository.json.FacilityRepository;
import com.infoshare.service.domain.workoutPlace.SportFacility;

import java.util.Map;

public class FacilityConsoleService {

    //TODO add facility filter method

    private FacilityRepository facilityRepository;

    public FacilityConsoleService() {
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
