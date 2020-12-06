package com.infoshare.activities;

import com.infoshare.tools.Tools;

public enum ActivityLevel {
    NEWBIE,
    ROOKIE,
    INTERMEDIATE,
    ADVANCED,
    EXPERT;

    public static void printValues() {
        for (ActivityLevel x : values()) {
            System.out.println(x);
        }
    }

    public static ActivityLevel valueOfLabel(String label) {
        for (int i = 0; i < ActivityLevel.values().length; i++) {
            if (values()[i].name().equals(label.toUpperCase())) {
                return values()[i];
            }
        }
        return Tools.getActivityLevelFromUser("There's no such a level of activity. Choose one from the following: ");
    }
}

