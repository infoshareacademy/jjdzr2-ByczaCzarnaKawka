package com.infoshare.activities;

import com.infoshare.tools.Tools;

public enum SportDisciplines {
    FOOTBALL,
    BADMINTON,
    FIELD_HOCKEY,
    VOLLEYBALL,
    BASKETBALL,
    TENNIS,
    CRICKET,
    TABLE_TENNIS,
    BASEBALL,
    GOLF,
    RUGBY,
    RUNNING,
    ATHLETICS,
    BOXING,
    ICE_HOKEY,
    CYCLING,
    SWIMMING,
    SNOOKER,
    MIXED_MARTIAL_ARTS,
    HANDBALL,
    HORSE_RACING,
    GYMNASTICS,
    SAILING,
    CURLING,
    DARTS,
    MOTOCROSS,
    SQUASH;

    public static void printValiu(){
        for (SportDisciplines x:values()){
            System.out.println(x);
        }
    }

    public static SportDisciplines valueOfLabel(String label){
        for(int i=0;i<SportDisciplines.values().length;i++){
            if(values()[i].name().equals(label.toUpperCase())){
                return values()[i];
            }
        }
        return Tools.getSportDisciplinesFromUser("Nie ma takiej dyscypliny, wybież z listy: ");
    }
}
