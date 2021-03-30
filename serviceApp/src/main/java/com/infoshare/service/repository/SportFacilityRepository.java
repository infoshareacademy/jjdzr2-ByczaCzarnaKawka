package com.infoshare.service.repository;

import com.infoshare.service.entity.SportFacilityEntity;
import com.infoshare.service.entity.id.SportFacilityID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportFacilityRepository extends JpaRepository<SportFacilityEntity, SportFacilityID> {
}
