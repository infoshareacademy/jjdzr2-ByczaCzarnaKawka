package repository;

import entity.SportDisciplineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportDisciplineRepository extends JpaRepository<SportDisciplineEntity,SportDisciplineEntity> {
}
