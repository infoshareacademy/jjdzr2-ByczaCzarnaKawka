package entity;

import entity.id.DisciplineId;

import javax.persistence.*;

@Entity
@Table(name = "disciplines")
@IdClass(DisciplineId.class)
public class DisciplinesEntity {

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
