package com.infoshare.web.controller;

import com.infoshare.service.service.json.RegisterService;
import com.infoshare.service.domain.users.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("town", registerService.getTownName());
        model.addAttribute("userGender", registerService.getUserGender());
        model.addAttribute("userDisciplines", registerService.getUserSportDiscipline());
        model.addAttribute("userActivityLevels", registerService.getUserActivityLevels());
        return "register";
    }

    @PostMapping("/register_send")
    public String sendProject(@Valid @ModelAttribute("user") UserDTO newUser, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("town", registerService.getTownName());
            model.addAttribute("userGender", registerService.getUserGender());
            model.addAttribute("userDisciplines", registerService.getUserSportDiscipline());
            model.addAttribute("userActivityLevels", registerService.getUserActivityLevels());
            return "register";
        } else {
            registerService.saveNewUser(newUser);
            return "register_success";
        }
    }

}

