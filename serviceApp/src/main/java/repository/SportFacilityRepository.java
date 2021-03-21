package repository;

import entity.SportFacilityEntity;
import entity.id.SportFacilityID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportFacilityRepository extends JpaRepository<SportFacilityEntity, SportFacilityID> {
}
