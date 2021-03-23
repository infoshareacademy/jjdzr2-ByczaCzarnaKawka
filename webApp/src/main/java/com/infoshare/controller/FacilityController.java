package com.infoshare.controller;

import com.infoshare.services.FacilityService;
import domain.activities.SportDisciplines;
import domain.location.Town;
import domain.workoutPlaces.SportFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

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

    @GetMapping("/find_facility")
    public String findFacility(Model model) {
        model.addAttribute("town", facilityService.getTownName());
        model.addAttribute("sportDisciplines", facilityService.getSportDiscipline());
        return "findFacilities";
    }

    @GetMapping("/found_facility")
    public String foundFacility(@RequestParam (required = false, defaultValue = "ALL") String town , @RequestParam(required = false, defaultValue = "ALL") String sportDisciplines, @RequestParam (required = false, defaultValue = "ALL") String club, Model model) {
        model.addAttribute("facilities", facilityService.findSportFacility(town, sportDisciplines, club));
        return "allFacilitiesList";
    }
}
