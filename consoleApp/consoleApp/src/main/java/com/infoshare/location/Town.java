package com.infoshare.location;

import com.infoshare.activities.ActivityLevel;
import com.infoshare.tools.Tools;

public enum Town {
    BIAŁYSTOK,
    BYDGOSZCZ,
    CZĘSTOCHOWA,
    GDAŃSK,
    GDYNIA,
    KATOWICE,
    KRAKÓW,
    ŁÓDŹ,
    POZNAŃ,
    WARSZAWA,
    WROCŁAW;

    public static void printValiu(){
        for (Town x:values()){
            System.out.println(x);
        }
    }

    public static Town valueOfLabel(String label){
        for(int i=0;i<Town.values().length;i++){
            if(values()[i].name().equals(label.toUpperCase())){
                return values()[i];
            }
        }
        return Tools.getTownFromUser("Nie nie ma takiego miasta, wybierz z listy: ");
    }
}
