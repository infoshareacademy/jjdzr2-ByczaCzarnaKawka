package domain.location;


public enum Town {
    BIALYSTOK,
    BYDGOSZCZ,
    CZESTOCHOWA,
    GDANSK,
    GDYNIA,
    KATOWICE,
    CRACOW,
    LODZ,
    POZNAN,
    WARSAW,
    WROCLAW,
    UNKNOWN;

    public static void printValue() {

        for (Town x : values()) {
            System.out.println(x);
        }
    }
}
