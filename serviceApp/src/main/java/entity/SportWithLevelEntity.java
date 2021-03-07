package entity;

import entity.id.SportWithLevelID;

import javax.persistence.*;

@Entity
@Table(name = "sport_with_activity_level")
@IdClass(SportWithLevelID.class)
public class SportWithLevelEntity {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private SportDisciplineEntity sportDiscipline;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private ActivityLevelEntity activityLevel;

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
