package entity.id;

import entity.ActivityLevelEntity;
import entity.SportDisciplineEntity;

import java.io.Serializable;
import java.util.Objects;

public class SportWithLevelID implements Serializable {

    private SportDisciplineEntity sportDiscipline;

    private ActivityLevelEntity activityLevel;

    public SportWithLevelID() {
    }

    public SportWithLevelID(final SportDisciplineEntity sportDiscipline, final ActivityLevelEntity activityLevel) {
        this.sportDiscipline = sportDiscipline;
        this.activityLevel = activityLevel;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SportWithLevelID that = (SportWithLevelID) o;
        return Objects.equals(sportDiscipline, that.sportDiscipline) && Objects.equals(activityLevel, that.activityLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportDiscipline, activityLevel);
    }
}
