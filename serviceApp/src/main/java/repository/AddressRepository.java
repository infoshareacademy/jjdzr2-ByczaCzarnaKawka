package repository;

import domain.location.Town;
import entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    List<AddressEntity> findAllByTown(Town townName);

    void deleteAllByTown(Town townName);

}
