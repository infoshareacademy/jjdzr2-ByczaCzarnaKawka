package com.infoshare.dao;

import com.infoshare.activities.SportDisciplines;
import com.infoshare.location.Address;
import com.infoshare.location.Town;
import com.infoshare.workoutPlaces.SportFacility;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

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

        SportFacility facility1 = new SportFacility("COS Gdańsk", SportDisciplines.BASKETBALL, "123456789",
                new Address(Town.GDAŃSK, "ul. Sportowa 1"),
                LocalTime.of(15, 00), LocalTime.of(16, 00), new BigDecimal("200"));

        SportFacility facility2 = new SportFacility("COS Łódź", SportDisciplines.BOXING, "147258369",
                new Address(Town.ŁÓDŹ, "ul. Bokserska 1"),
                LocalTime.of(15, 00), LocalTime.of(16, 00), new BigDecimal("50"));

        SportFacility facility3 = new SportFacility("COS Białystok", SportDisciplines.BOXING, "147258369",
                new Address(Town.BIAŁYSTOK, "ul. Bokserska 1"),
                LocalTime.of(15, 00), LocalTime.of(16, 00), new BigDecimal("50"));

        facilityMap.put(facility1.getOrdinalNumber(), facility1);
        facilityMap.put(facility2.getOrdinalNumber(), facility2);
        facilityMap.put(facility3.getOrdinalNumber(), facility3);

    }

}
