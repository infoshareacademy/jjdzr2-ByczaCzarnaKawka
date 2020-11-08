package com.infoshare.users;

public enum Sex {
    MALE,
    FEMALE,
    KOBIETA,
    MĘŻCZYZNA;

    public static void printValiu(){
        for (Sex x:values()){
            System.out.println(x);
        }
    }

    public static Sex valueOfLabel(String label){
        boolean flag=false;
        do {
            for (Sex x : values()) {
                if (x.name().equals(label.toUpperCase())) {
                    flag=true;
                    return x;
                }
            }
            return valueOfLabel("Coś nie nie zgadza, podaj płeć: ");
        }while (!flag);

    }

}
