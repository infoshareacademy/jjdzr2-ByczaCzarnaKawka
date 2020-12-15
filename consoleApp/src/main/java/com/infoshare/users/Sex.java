package com.infoshare.users;

import com.infoshare.tools.Tools;

public enum Sex {
    KOBIETA,
    MĘŻCZYZNA;

    public static void printValues() {
        for (Sex x : values()) {
            System.out.println(x);

        }
    }

    public static Sex valueOfLabel(String label) {
        for (int i = 0; i < Sex.values().length; i++) {
            if (values()[i].name().equals(label.toUpperCase())) {
                return values()[i];
            }
        }
        return Tools.getSexFromUser("Coś jest nie tak, podaj pleć: ");
    }
}