package com.infoshare.service.service;

import org.springframework.stereotype.Component;

@Component
public class MenuService {

    private static final String MENU_HEADER = "Welcome in *** GymBuddy Finder ***";

    public String getMenuHeader(){
        return MENU_HEADER;
    }
}

