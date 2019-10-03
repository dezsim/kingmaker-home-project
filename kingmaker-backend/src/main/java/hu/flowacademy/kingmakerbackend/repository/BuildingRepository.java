package hu.flowacademy.kingmakerbackend.repository;

import hu.flowacademy.kingmakerbackend.model.building.Building;
import hu.flowacademy.kingmakerbackend.model.building.BuildingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    Building findByBuildingType(BuildingType building);
}
