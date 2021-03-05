package repository;

import domain.activities.ActivityLevel;
import domain.activities.SportDiscipline;
import entity.DisciplineWithLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinesWIthLevelsRepository
        extends JpaRepository<DisciplineWithLevelEntity, Long> {

    DisciplineWithLevelEntity getByActivityLevelAndSportDiscipline(
            ActivityLevel activityLevel, SportDiscipline sportDiscipline);

}
