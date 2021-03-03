package entities;

import domain.activities.ActivityLevel;
import domain.activities.SportDiscipline;

import javax.persistence.*;

@Entity
@Table(name = "disciplines_with_levels")
class DisciplineWithLevelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private SportDiscipline sportDiscipline;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private ActivityLevel activityLevel;

    Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    SportDiscipline getSportDiscipline() {
        return sportDiscipline;
    }

    void setSportDiscipline(final SportDiscipline sportDiscipline) {
        this.sportDiscipline = sportDiscipline;
    }

    ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    void setActivityLevel(final ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }
}
