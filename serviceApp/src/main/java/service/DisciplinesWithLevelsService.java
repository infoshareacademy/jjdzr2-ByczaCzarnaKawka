package service;

import domain.activities.ActivityLevel;
import domain.activities.SportDiscipline;
import entity.DisciplineWithLevelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DisciplinesWIthLevelsRepository;

import javax.annotation.PostConstruct;

import static java.util.Arrays.stream;

@Service
public class DisciplinesWithLevelsService {

    private final DisciplinesWIthLevelsRepository disciplinesWIthLevelsRepo;

    @Autowired
    DisciplinesWithLevelsService(DisciplinesWIthLevelsRepository disciplinesWIthLevelsRepo) {
        this.disciplinesWIthLevelsRepo = disciplinesWIthLevelsRepo;
    }

    @PostConstruct
    public void init() {
        createDisciplinesWithLevels();
    }

    private void createDisciplinesWithLevels() {
        stream(ActivityLevel.values()).forEach(this::combineLevelsWithDisciplines);
    }

    private void combineLevelsWithDisciplines(ActivityLevel activityLevel) {
        stream(SportDiscipline.values()).forEach(
                sportDiscipline -> saveEntity(activityLevel, sportDiscipline));
    }

    private void saveEntity(final ActivityLevel activityLevel, final SportDiscipline sportDiscipline) {
        final DisciplineWithLevelEntity disciplineWithLevelEntity = new DisciplineWithLevelEntity();
        disciplineWithLevelEntity.setActivityLevel(activityLevel);
        disciplineWithLevelEntity.setSportDiscipline(sportDiscipline);
        disciplinesWIthLevelsRepo.save(disciplineWithLevelEntity);
    }

}
