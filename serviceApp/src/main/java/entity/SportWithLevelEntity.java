package entity;

import entity.id.SportWithLevelID;

import javax.persistence.*;

@Entity
@Table(name = "sport_with_activity_level")
@IdClass(SportWithLevelID.class)
public class SportWithLevelEntity {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sport_discipline")
    private SportDisciplineEntity sportDisciplineEntity;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activity_level")
    private ActivityLevelEntity activityLevelEntity;

    public SportDisciplineEntity getSportDisciplineEntity() {
        return sportDisciplineEntity;
    }

    public void setSportDisciplineEntity(final SportDisciplineEntity sportDiscipline) {
        this.sportDisciplineEntity = sportDiscipline;
    }

    public ActivityLevelEntity getActivityLevelEntity() {
        return activityLevelEntity;
    }

    public void setActivityLevelEntity(final ActivityLevelEntity activityLevel) {
        this.activityLevelEntity = activityLevel;
    }
}
