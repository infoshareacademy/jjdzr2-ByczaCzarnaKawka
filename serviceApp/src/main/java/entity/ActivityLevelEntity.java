package entity;

import domain.activities.ActivityLevel;

import javax.persistence.*;

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
}
