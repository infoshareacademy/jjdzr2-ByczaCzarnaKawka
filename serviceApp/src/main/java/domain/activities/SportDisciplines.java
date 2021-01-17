package domain.activities;

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

}
