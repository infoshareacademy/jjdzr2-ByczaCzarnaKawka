package com.infoshare.location;

public class Address {
    private Town townName;
    private LocalRoad localRoad;

    public Address(Town townName) {
        this.townName = townName;
    }

    public Address(Town townName, LocalRoad localRoad) {
        this.townName = townName;
        this.localRoad = localRoad;
    }

    public Town getTownName() {
        return townName;
    }

    public void setTownName(Town townName) {
        this.townName = townName;
    }

    public LocalRoad getLocalRoad() {
        return localRoad;
    }

    public void setLocalRoad(LocalRoad localRoad) {
        this.localRoad = localRoad;
    }
}
