package entity.id;

import entity.ActivityLevelEntity;
import entity.SportDisciplineEntity;

import java.io.Serializable;
import java.util.Objects;

public class SportWithLevelID implements Serializable {

    private SportDisciplineEntity sportDisciplineEntity;

    private ActivityLevelEntity activityLevelEntity;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SportWithLevelID that = (SportWithLevelID) o;
        return Objects.equals(sportDisciplineEntity, that.sportDisciplineEntity) && Objects.equals(activityLevelEntity, that.activityLevelEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportDisciplineEntity, activityLevelEntity);
    }
}
