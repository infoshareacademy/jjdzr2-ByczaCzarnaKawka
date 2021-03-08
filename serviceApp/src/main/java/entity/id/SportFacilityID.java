package entity.id;

import entity.SportDisciplineEntity;

import java.io.Serializable;

public class SportFacilityID implements Serializable {

    private String facilityName;

    private SportDisciplineEntity sportDiscipline;

    public SportFacilityID() {
    }

    public SportFacilityID(final String facilityName, final SportDisciplineEntity sportDiscipline) {
        this.facilityName = facilityName;
        this.sportDiscipline = sportDiscipline;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(final String facilityName) {
        this.facilityName = facilityName;
    }

    public SportDisciplineEntity getSportDiscipline() {
        return sportDiscipline;
    }

    public void setSportDiscipline(final SportDisciplineEntity sportDiscipline) {
        this.sportDiscipline = sportDiscipline;
    }
}
