package hu.flowacademy.kingmakerbackend.resource;

import hu.flowacademy.kingmakerbackend.model.Player;
import hu.flowacademy.kingmakerbackend.model.building.Building;
import hu.flowacademy.kingmakerbackend.model.building.BuildingType;
import hu.flowacademy.kingmakerbackend.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Building addBuilding(@RequestBody Building building){
        return buildingRepository.save(building);
    }

    @GetMapping("/building/{id}")
    public int findById(@PathVariable Long id){
        return buildingRepository.getOne(1L).getBuildingType().getBuildingInterest();
    /*    return buildingRepository.findById(id).orElse(null);*/
    }
}
