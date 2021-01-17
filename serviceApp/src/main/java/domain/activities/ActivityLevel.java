package domain.activities;

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
  }


