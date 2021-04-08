package com.infoshare.service.domain.users;


public enum Gender {
    FEMALE,
    MALE;

    public static void printValues() {
        for (Gender x : values()) {
            System.out.println(x);

        }
    }

}
