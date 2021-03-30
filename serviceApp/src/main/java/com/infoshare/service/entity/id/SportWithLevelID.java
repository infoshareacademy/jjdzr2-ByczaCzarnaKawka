package com.infoshare.service.entity.id;

import com.infoshare.service.domain.activities.ActivityLevel;
import com.infoshare.service.domain.activities.SportDiscipline;

import java.io.Serializable;
import java.util.Objects;

public class SportWithLevelID implements Serializable {

    private SportDiscipline sportDiscipline;

    private ActivityLevel activityLevel;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SportWithLevelID that = (SportWithLevelID) o;
        return sportDiscipline == that.sportDiscipline && activityLevel == that.activityLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportDiscipline, activityLevel);
    }
}
