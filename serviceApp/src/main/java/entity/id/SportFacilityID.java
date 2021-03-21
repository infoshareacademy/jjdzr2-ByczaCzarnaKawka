package entity.id;

import domain.activities.SportDiscipline;

import java.io.Serializable;
import java.util.Objects;

public class SportFacilityID implements Serializable {

    private String facilityName;

    private SportDiscipline sportDiscipline;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SportFacilityID that = (SportFacilityID) o;
        return Objects.equals(facilityName, that.facilityName) && sportDiscipline == that.sportDiscipline;
    }

    @Override
    public int hashCode() {
        return Objects.hash(facilityName, sportDiscipline);
    }
}

