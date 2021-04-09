package com.infoshare.web.controller;

import com.infoshare.service.domain.activities.SportDiscipline;
import com.infoshare.service.domain.location.Town;
import com.infoshare.service.entity.SportFacilityEntity;
import com.infoshare.service.service.json.FacilityService;
import com.infoshare.service.domain.workoutPlace.SportFacility;
import com.infoshare.service.service.mysql.SportFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService facilityService;
    private final SportFacilityService sportFacilityService;

    @Autowired
    public FacilityController(FacilityService facilityService, SportFacilityService sportFacilityService) {
        this.facilityService = facilityService;
        this.sportFacilityService = sportFacilityService;
    }

    // lista wszystkich obiektów z json
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

    //lista obiektow spełniających kryteria wyszukanych z jsona
    @GetMapping("/found_facility_list")
    public String foundFacilityList(@RequestParam(required = false, defaultValue = "ALL") String town, @RequestParam(required = false, defaultValue = "ALL") String sportDisciplines, @RequestParam(required = false, defaultValue = "ALL") String club, Model model) {
        List<SportFacility> currentFacilitiesList = facilityService.findSportFacility(town, sportDisciplines, club);

        if (currentFacilitiesList.isEmpty()) {
            String info = "Unfortunately there's no facilities to book, on the list...";
            model.addAttribute(info);
            return "emptyFacilitiesList";
        } else {
            model.addAttribute("facilities", currentFacilitiesList);
            return "allFacilitiesList";
        }
    }


//formulaż wyszukiwania
    @GetMapping("/find_facility")
    public String findFacility(Model model) {
        model.addAttribute("town", facilityService.getTownName());
        model.addAttribute("sportDisciplines", facilityService.getSportDiscipline());
        return "findFacilities";
    }

    //lista wszystkich obiektów z bazy
    @GetMapping("/facility_list")
    public String getAllFacilityListDB(Model model) {
        List<SportFacilityEntity> currentFacilitiesList = sportFacilityService.getAllSportFacilities();

        if (currentFacilitiesList.isEmpty()) {
            String info = "Unfortunately there's no facilities to book, on the list...";
            model.addAttribute(info);
            return "emptyFacilitiesList";
        } else {
            model.addAttribute("facilities", currentFacilitiesList);
            return "allFacilitiesListDB";
        }
    }

    //lista obiektow spełniających kryteria wyszukanych z bazy
    @GetMapping("/found_facility")
    public String foundFacility(@RequestParam(required = false, defaultValue = "ALL") Town town, @RequestParam(required = false, defaultValue = "ALL") SportDiscipline sportDisciplines, @RequestParam(required = false, defaultValue = "ALL") String club, Model model) {
        List<SportFacilityEntity> currentFacilitiesList = sportFacilityService.findSportFacility(town, sportDisciplines, club);

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
