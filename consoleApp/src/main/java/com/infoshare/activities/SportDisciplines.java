package com.infoshare.activities;

import com.infoshare.tools.Tools;

public enum SportDisciplines {
    FOOTBALL,
    BADMINTON,
    FIELD_HOCKEY,
    VOLLEYBALL,
    BASKETBALL,
    TENNIS,
    TABLE_TENNIS,
    GOLF,
    RUNNING,
    BOXING,
    ICE_HOCKEY,
    CYCLING,
    SWIMMING,
    SNOOKER,
    MIXED_MARTIAL_ARTS,
    HANDBALL,
    DARTS,
    MOTOCROSS,
    SQUASH,
    CHESS;


    public static void printValues() {
        for (SportDisciplines x : values()) {
            System.out.println(x);
        }
    }

    public static SportDisciplines valueOfLabel(String label) {
        for (int i = 0; i < SportDisciplines.values().length; i++) {
            if (values()[i].name().equals(label.toUpperCase())) {
                return values()[i];
            }
        }
        return Tools.getSportDisciplinesFromUser("There's no such an activity. Choose one from the following: ");
    }
}
