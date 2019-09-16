package hu.flowacademy.kingmakerbackend.resource;

import hu.flowacademy.kingmakerbackend.model.Player;
import hu.flowacademy.kingmakerbackend.model.building.Building;
import hu.flowacademy.kingmakerbackend.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Rest {

    @Autowired
    BuildingRepository buildingRepository;

    @GetMapping("")
    public Player findBy(){
        return new Player();
    }

    @PostMapping("")
    public Building addBuilding(Building building){
        return buildingRepository.save(building);
    }
}
