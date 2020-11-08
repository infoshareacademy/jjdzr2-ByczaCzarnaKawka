package com.infoshare.location;

public class LocalRoad {
    private String roadName;
    private String buildingNo;

    public LocalRoad() {
    }

    public LocalRoad(String roadName) {
        this.roadName = roadName;
    }

    public LocalRoad(String roadName, String buildingNo) {
        this.roadName = roadName;
        this.buildingNo = buildingNo;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    @Override
    public String toString() {
        return roadName + " " + buildingNo;
    }
}
