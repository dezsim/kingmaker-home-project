package hu.flowacademy.kingmakerbackend.repository;

import hu.flowacademy.kingmakerbackend.model.building.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
