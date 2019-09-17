package hu.flowacademy.kingmakerbackend.resource;

import hu.flowacademy.kingmakerbackend.model.Player;
import hu.flowacademy.kingmakerbackend.model.building.*;
import hu.flowacademy.kingmakerbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Rest {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public Rest() {
    }

    @GetMapping("")
    public List<Player> findBy(){
        return playerRepository.findAll();
    }

    @PostMapping("/player/")
    public Player newPlayer(@RequestParam("username") String username){
        return playerRepository.save(new Player(username));
    }

    @PostMapping("/building/")
    public Building addBuilding(@RequestBody Building building){
       /* buildingRepository.save(new Building(BuildingType.BANK, newPlayer("kuka")));*/
        return buildingRepository.save(building);
    }

    @GetMapping("/building/{id}")
    public Building findById(@PathVariable Long id){
       /* return buildingRepository.getOne(1L).getBuildingType().getBuildingInterest()*/;
        return buildingRepository.findById(id).orElse(null);
    }
}
