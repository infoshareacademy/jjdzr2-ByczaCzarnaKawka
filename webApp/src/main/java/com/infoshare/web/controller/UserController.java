package com.infoshare.web.controller;

import com.infoshare.service.domain.users.UserDTO;
import com.infoshare.service.service.json.RegisterService;
import com.infoshare.service.service.json.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

    private final RegisterService registerService;
    private final UserService userService;

    @Autowired
    public UserController(RegisterService registerService, UserService userService) {
        this.registerService = registerService;
        this.userService = userService;
    }

    @GetMapping("/edit")
    public String getForm(Model model) {
        UserDTO user = userService.getCurrentUser().map(userService::convertToDto).orElse(new UserDTO());
        user.setMailAddress(UUID.randomUUID() + "@gmail.com"); // circumvent validation logic
        model.addAttribute("user", user);
        model.addAttribute("town", registerService.getTownName());
        model.addAttribute("userGender", registerService.getUserGender());
        model.addAttribute("userSportDisciplines", registerService.getUserSportDiscipline());
        model.addAttribute("userActivityLevels", registerService.getUserActivityLevels());
        return "edit";
    }

    @PostMapping("/edit_send")
    public String saveUser(@Valid @ModelAttribute("user") UserDTO user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("town", registerService.getTownName());
            model.addAttribute("userGender", registerService.getUserGender());
            model.addAttribute("userSportDisciplines", registerService.getUserSportDiscipline());
            model.addAttribute("userActivityLevels", registerService.getUserActivityLevels());
            return "edit";
        } else {
            user.setMailAddress(userService.getCurrentUser().get().getMailAddress());
            userService.updateUser(user);
            return "playerView";
        }
    }

    @GetMapping ("/delete")
    public String delete() {
        userService.deleteUser(userService.getCurrentUser().get().getMailAddress());
        userService.logOut();
        return "login";
    }
}
