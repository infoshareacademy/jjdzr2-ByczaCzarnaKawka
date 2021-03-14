package entity;

import domain.activities.SportDiscipline;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SportDisciplineEntity that = (SportDisciplineEntity) o;
        return sportDiscipline == that.sportDiscipline;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportDiscipline);
    }
}
