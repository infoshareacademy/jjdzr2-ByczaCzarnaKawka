package entity.id;

import domain.activities.SportDiscipline;
import entity.SportDisciplineEntity;

import java.io.Serializable;
import java.util.Objects;

public class SportFacilityID implements Serializable {

    private String facilityName;

    private SportDisciplineEntity sportDisciplineEntity;

    //FIXME: Unacceptable solution. Need to investigate why a SportDiscipline is passed instead of a
    // SportDisciplineEntity
    public void setSportDisciplineEntity(final SportDiscipline sportDiscipline) {
        SportDisciplineEntity sportDisciplineEntity= new SportDisciplineEntity();
        sportDisciplineEntity.setSportDiscipline(sportDiscipline);
        this.sportDisciplineEntity = sportDisciplineEntity ;
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

