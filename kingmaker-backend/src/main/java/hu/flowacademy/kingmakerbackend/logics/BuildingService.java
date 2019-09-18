package hu.flowacademy.kingmakerbackend.logics;

import hu.flowacademy.kingmakerbackend.model.Player;
import hu.flowacademy.kingmakerbackend.model.building.Building;
import hu.flowacademy.kingmakerbackend.repository.BuildingRepository;
import hu.flowacademy.kingmakerbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BuildingService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    public Building build(Building building){
        Player player = playerRepository.findById(building.getPlayer().getId()).get();
        if( player.getGold() >= building.getBuildingType().getBuildingPrice()){
            player.setGold(player.getGold() - building.getBuildingType().getBuildingPrice());
            return buildingRepository.save(building);
        } else {
            throw new IllegalArgumentException("Kevés zseton");
        }
    }


}
