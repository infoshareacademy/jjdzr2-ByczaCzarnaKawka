package com.infoshare.location;

public class Address {
    private Town townName;
    private String roadName;

    public Address(Town townName) {

        this.townName = townName;
    }

    public Address(Town townName, String roadName) {
        this.townName = townName;
        this.roadName = roadName;
    }

    public Town getTownName() {
        return townName;
    }

    public void setTownName(Town townName) {
        this.townName = townName;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    @Override
    public String toString() {
        return "Address: \n" +
                "Town: " + townName +
                "," + "\n" + "Road: " + roadName;
    }
}
