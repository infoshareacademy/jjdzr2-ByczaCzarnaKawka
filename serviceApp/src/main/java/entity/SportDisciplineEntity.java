package entity;

import domain.activities.SportDiscipline;

import javax.persistence.*;

@Entity
@Table(name = "sport_discipline")
public class SportDisciplineEntity {

    @Id
    @Enumerated(EnumType.STRING)
    private SportDiscipline sportDiscipline;

    public SportDiscipline getSportDiscipline() {
        return sportDiscipline;
    }

    public void setSportDiscipline(final SportDiscipline sportDiscipline) {
        this.sportDiscipline = sportDiscipline;
    }
}
