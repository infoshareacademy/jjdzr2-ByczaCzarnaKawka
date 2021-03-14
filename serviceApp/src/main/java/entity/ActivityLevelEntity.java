package entity;

import domain.activities.ActivityLevel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "activity_level")
public class ActivityLevelEntity {

    @Id
    @Enumerated(EnumType.STRING)
    private ActivityLevel activityLevel;

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(final ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ActivityLevelEntity that = (ActivityLevelEntity) o;
        return activityLevel == that.activityLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityLevel);
    }
}
