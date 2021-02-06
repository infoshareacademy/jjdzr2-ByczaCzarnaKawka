package com.infoshare.register;

import com.infoshare.tools.Tools;
import domain.users.User;
import domain.users.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import validate.NewPasswordValidator;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

//    @InitBinder("userDTO")
//    protected void initBinder(WebDataBinder binder) {
//        binder.addValidators(new NewPasswordValidator());
//    }

    @GetMapping("/register")
    public String register(Model model, String repeatPassword) {
        repeatPassword="123qwe";
        model.addAttribute("user", new UserDTO());
        model.addAttribute("town", registerService.getTownName());
        model.addAttribute("userGender", registerService.getUserGender());
        model.addAttribute("userSportDisciplines", registerService.getUserSportDiscipline());
        model.addAttribute("userActivityLevels", registerService.getUserActivityLevels());
        return "register";
    }

    @PostMapping("/register_send")
    public String sendProject(@Valid @ModelAttribute("user") UserDTO newUser, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("town", registerService.getTownName());
            model.addAttribute("userGender", registerService.getUserGender());
            model.addAttribute("userSportDisciplines", registerService.getUserSportDiscipline());
            model.addAttribute("userActivityLevels", registerService.getUserActivityLevels());
            return "register";
        } else {
            registerService.saveNewUser(newUser);
            return "register_success";
        }

    }

}

