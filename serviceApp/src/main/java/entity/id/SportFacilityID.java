package entity.id;

import entity.SportDisciplineEntity;

import java.io.Serializable;
import java.util.Objects;

public class SportFacilityID implements Serializable {

    private String facilityName;

    private SportDisciplineEntity sportDisciplineEntity;

    public SportFacilityID() {
    }

    public SportFacilityID(final String facilityName, final SportDisciplineEntity sportDisciplineEntity) {
        this.facilityName = facilityName;
        this.sportDisciplineEntity = sportDisciplineEntity;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SportFacilityID that = (SportFacilityID) o;
        return Objects.equals(facilityName, that.facilityName) && Objects.equals(sportDisciplineEntity, that.sportDisciplineEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facilityName, sportDisciplineEntity);
    }
}
