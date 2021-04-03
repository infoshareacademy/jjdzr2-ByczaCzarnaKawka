package domain.activities;

public enum SportDiscipline {
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
    CHESS,
    ALL;


    public static void printValues() {
        for (SportDiscipline x : values()) {
            System.out.println(x);
        }
    }



}
