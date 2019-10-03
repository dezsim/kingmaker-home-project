package hu.flowacademy.kingmakerbackend.logics;

import hu.flowacademy.kingmakerbackend.model.Player;
import hu.flowacademy.kingmakerbackend.model.building.Building;
import hu.flowacademy.kingmakerbackend.repository.BuildingRepository;
import hu.flowacademy.kingmakerbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
@Transactional
public class BuildingService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    private ResponseStatusException NOT_ENOUGH_GOLD = new ResponseStatusException(HttpStatus.NOT_FOUND, "Not enough gold!");

    public Building build(Building building){
        Player player = playerRepository.findByUsername(building.getPlayer().getUsername());
        if( player.getGold() >= building.getBuildingType().getBuildingPrice()){
            player.setGold(player.getGold() - building.getBuildingType().getBuildingPrice());
        return buildingRepository.save(new Building(building.getBuildingType(), player));
        } else {
            throw NOT_ENOUGH_GOLD;
        }
    }


    public Building findById(Long id) {
        return buildingRepository.findById(id).orElse(null);
    }
}
