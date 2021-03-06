package com.infoshare.service.entity;

import com.infoshare.service.domain.activities.ActivityLevel;
import com.infoshare.service.domain.activities.SportDiscipline;
import com.infoshare.service.entity.id.SportWithLevelID;

import javax.persistence.*;

@Entity
@Table(name = "sport_with_activity_level")
@IdClass(SportWithLevelID.class)
public class SportWithLevelEntity {

    @Id
    @Enumerated(EnumType.STRING)
    private SportDiscipline sportDiscipline;

    @Id
    @Enumerated(EnumType.STRING)
    private ActivityLevel activityLevel;

    public SportDiscipline getSportDiscipline() {
        return sportDiscipline;
    }

    public void setSportDiscipline(final SportDiscipline sportDiscipline) {
        this.sportDiscipline = sportDiscipline;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(final ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }
}
