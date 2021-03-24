package repository;

import entity.SportWithLevelEntity;
import entity.id.SportWithLevelID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportWithLevelRepository extends JpaRepository<SportWithLevelEntity, SportWithLevelID> {

}
