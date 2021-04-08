package com.infoshare.service.repository;

import com.infoshare.service.entity.SportWithLevelEntity;
import com.infoshare.service.entity.id.SportWithLevelID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportWithLevelRepository extends JpaRepository<SportWithLevelEntity, SportWithLevelID> {

}
