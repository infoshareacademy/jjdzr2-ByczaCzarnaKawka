package com.infoshare.service.service.json;

import com.infoshare.service.domain.workoutPlace.SportFacility;
import org.springframework.stereotype.Service;
import com.infoshare.service.utils.FileUtils;

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
