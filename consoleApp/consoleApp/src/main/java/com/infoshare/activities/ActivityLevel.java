package com.infoshare.activities;

import com.infoshare.tools.Tools;
import com.infoshare.users.Sex;

public enum ActivityLevel {
    NEWBIE,
    ROOKIE,
    INTERMEDIATE,
    ADVANCED,
    EXPERT;

    public static void printValiu(){
        for (ActivityLevel x:values()){
            System.out.println(x);
        }
    }

    public static ActivityLevel valueOfLabel(String label){
        for(int i=0;i<ActivityLevel.values().length;i++){
            if(values()[i].name().equals(label.toUpperCase())){
                return values()[i];
            }
        }
        return Tools.getActivityLevelFromUser("Nie przewidujemy takiego poziomu zaawansowania, wybierz z listy: ");
    }

    }
