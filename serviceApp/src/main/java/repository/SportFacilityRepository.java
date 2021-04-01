package repository;

import domain.activities.SportDiscipline;
import domain.location.Town;
import entity.SportFacilityEntity;
import entity.id.SportFacilityID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportFacilityRepository extends JpaRepository<SportFacilityEntity, SportFacilityID> {

    List<SportFacilityEntity> findByAddressEntity_TownOrderByFacilityName(Town town);

    List<SportFacilityEntity> findBySportDiscipline(SportDiscipline sportDiscipline);

    List<SportFacilityEntity> findByFacilityNameContains(String name);

}
