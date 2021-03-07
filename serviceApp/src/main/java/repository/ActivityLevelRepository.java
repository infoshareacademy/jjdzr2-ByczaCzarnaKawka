package repository;

import entity.ActivityLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLevelRepository extends JpaRepository<ActivityLevelEntity,ActivityLevelEntity>{

}
