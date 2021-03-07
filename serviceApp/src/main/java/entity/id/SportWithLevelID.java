package entity.id;

import entity.ActivityLevelEntity;
import entity.SportDisciplineEntity;

import java.io.Serializable;

public class SportWithLevelID implements Serializable {

    private SportDisciplineEntity sportDiscipline;

    private ActivityLevelEntity activityLevel;

    public SportWithLevelID() {
    }

    public SportWithLevelID(final SportDisciplineEntity sportDiscipline, final ActivityLevelEntity activityLevel) {
        this.sportDiscipline = sportDiscipline;
        this.activityLevel = activityLevel;
    }

    public SportDisciplineEntity getSportDiscipline() {
        return sportDiscipline;
    }

    public void setSportDiscipline(final SportDisciplineEntity sportDiscipline) {
        this.sportDiscipline = sportDiscipline;
    }

    public ActivityLevelEntity getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(final ActivityLevelEntity activityLevel) {
        this.activityLevel = activityLevel;
    }
}
