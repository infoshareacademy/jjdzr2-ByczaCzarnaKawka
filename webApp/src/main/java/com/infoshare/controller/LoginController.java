package com.infoshare.controller;

import domain.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

    @GetMapping("/")
    public RedirectView redirectBasicSlashURL(){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/login");
        return redirectView;
    }

    @GetMapping("/login")
    public String returnLoginForm(){
        return "login";
    }

    //TODO : it is temporary endpoint, I need something to test playerView and adminView
    @GetMapping("/login_send/{accessLevel}")
    public String sendLogin(@PathVariable String accessLevel){

        if("player".equals(accessLevel)){
            return "playerView";
        }
        else if ("admin".equals(accessLevel)){
            return "adminView";
        }
        return "login";
    }

}
