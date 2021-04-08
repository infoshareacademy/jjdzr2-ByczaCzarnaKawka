package com.infoshare.web.controller;

import com.infoshare.services.FacilityService;
import domain.activities.SportDiscipline;
import domain.location.Town;
import domain.workoutPlaces.SportFacility;
import entity.SportFacilityEntity;
import com.infoshare.service.service.json.FacilityService;
import com.infoshare.service.domain.workoutPlace.SportFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.SportFacilityService;

import java.util.List;

@Controller
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService facilityService;
    private final SportFacilityService sportFacilityService;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
        this.sportFacilityService = sportFacilityService;
    }

    // date of facility getting from JSON file
    @GetMapping("/list")
    public String getAllFacilityList(Model model) {
        List<SportFacility> currentFacilitiesList = facilityService.getSportFacilityList();

        if (currentFacilitiesList.isEmpty()) {
            String info = "Unfortunately there's no facilities to book, on the list...";
            model.addAttribute(info);
            return "emptyFacilitiesList";
        } else {
            model.addAttribute("facilities", currentFacilitiesList);
            return "allFacilitiesList";
        }
    }

    //date of facility getting from JSON file
    @GetMapping("/find_facility")
    public String findFacility(Model model) {
        model.addAttribute("town", facilityService.getTownName());
        model.addAttribute("sportDisciplines", facilityService.getSportDiscipline());
        return "findFacilities";
    }

    @GetMapping("/facility_list")
    public String getAllFacilityListDB(Model model) {
        List<SportFacilityEntity> currentFacilitiesList = sportFacilityService.getAllSportFacility();

        if (currentFacilitiesList.isEmpty()) {
            String info = "Unfortunately there's no facilities to book, on the list...";
            model.addAttribute(info);
            return "emptyFacilitiesList";
        } else {
            model.addAttribute("facilities", currentFacilitiesList);
            return "allFacilitiesListDB";
        }
    }

    @GetMapping("/found_facility")
    public String foundFacility(@RequestParam(required = false, defaultValue = "ALL") Town town, @RequestParam(required = false, defaultValue = "ALL") SportDiscipline sportDisciplines, @RequestParam(required = false, defaultValue = "ALL") String club, Model model) {
        List<SportFacilityEntity> currentFacilitiesList = sportFacilityService.findSportFacility(town, sportDisciplines, club);

        model.addAttribute("facilities", sportFacilityService.findSportFacility(town, sportDisciplines, club));

        if (currentFacilitiesList.isEmpty()) {
            String info = "Unfortunately there's no facilities to book, on the list...";
            model.addAttribute(info);
            return "emptyFacilitiesList";
        } else {
            model.addAttribute("facilities", currentFacilitiesList);
            return "allFacilitiesListDB";
        }
    }

}
