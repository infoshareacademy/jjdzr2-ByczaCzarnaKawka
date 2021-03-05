package entity;

import domain.activities.ActivityLevel;
import domain.activities.SportDiscipline;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "disciplines_with_levels")
public class DisciplineWithLevelEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Long id;

    @Enumerated(EnumType.STRING)
    private SportDiscipline sportDiscipline;

    @Enumerated(EnumType.STRING)
    private ActivityLevel activityLevel;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

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
