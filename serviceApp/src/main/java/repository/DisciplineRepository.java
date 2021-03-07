package repository;

import entity.DisciplinesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends JpaRepository<DisciplinesEntity, DisciplinesEntity> {
}
