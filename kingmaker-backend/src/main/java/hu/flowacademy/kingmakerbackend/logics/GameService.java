package hu.flowacademy.kingmakerbackend.logics;

import hu.flowacademy.kingmakerbackend.model.Player;
import hu.flowacademy.kingmakerbackend.model.game.GameModel;
import hu.flowacademy.kingmakerbackend.repository.BuildingRepository;
import hu.flowacademy.kingmakerbackend.repository.CrewRepository;
import hu.flowacademy.kingmakerbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GameService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private CrewRepository crewRepository;

    private List<GameModel> games = new ArrayList<>();
    private int playerNumber = 0;
    private Long gameNumber = 0L;

    public GameModel newGame(Player player) {
        if(games.size() == 0 || playerNumber % 2 == 0) {
            games.add(new GameModel(gameNumber++));
            games.get(games.size() - 1).setPlayerBlue(player);
            playerNumber++;
        } else {
            games.get(games.size() - 1).setPlayerRed(player);
            playerNumber++;
        }
        return games.get(games.size() - 1);
    }
}
