package hu.flowacademy.kingmakerbackend.logics;

import hu.flowacademy.kingmakerbackend.model.Player;
import hu.flowacademy.kingmakerbackend.model.game.GameModel;
import hu.flowacademy.kingmakerbackend.repository.BuildingRepository;
import hu.flowacademy.kingmakerbackend.repository.CrewRepository;
import hu.flowacademy.kingmakerbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    private ResponseStatusException PLAYER_EXC = new ResponseStatusException(HttpStatus.NOT_FOUND, "You cant play versus yourself");

    private List<GameModel> games = new ArrayList<>();
    private int playerNumber = 0;
    private Long gameNumber = 0L;

    public GameModel newGame(Player player) {
        if(games.size() == 0|| playerNumber % 2 == 0) {
            games.add(new GameModel(gameNumber++));
                games.get(games.size() - 1).setPlayerBlue(player);
                playerNumber++;
        } else {
            if (games.get(games.size() - 1).getPlayerBlue().getUsername().equals(player.getUsername())) {
                throw PLAYER_EXC;
            } else {
                games.get(games.size() - 1).setPlayerRed(player);
                playerNumber++;
            }
        }
        return games.get(games.size() - 1);
    }

    public GameModel findGameByUsername(String username) {
       return games.stream().filter(game -> game.getPlayerBlue().getUsername().equals(username) || game.getPlayerRed().getUsername().equals(username)).findFirst().get();
    }
}
