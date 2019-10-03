package hu.flowacademy.kingmakerbackend.resource;

import hu.flowacademy.kingmakerbackend.auth.CustomUserDetailsService;
import hu.flowacademy.kingmakerbackend.logics.BuildingService;
import hu.flowacademy.kingmakerbackend.logics.GameService;
import hu.flowacademy.kingmakerbackend.logics.MemberService;
import hu.flowacademy.kingmakerbackend.model.Player;
import hu.flowacademy.kingmakerbackend.model.building.*;
import hu.flowacademy.kingmakerbackend.model.crew.Member;
import hu.flowacademy.kingmakerbackend.model.game.GameModel;
import hu.flowacademy.kingmakerbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("")
public class Rest {


    @Autowired
    private BuildingService buildingService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private GameService gameService;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CrewRepository crewRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    public Rest() {
    }


    @PostMapping("/game/new/{username}")
    public GameModel newGame(@PathVariable String username){
        return gameService.newGame(playerRepository.findByUsername(username));
    }

    @GetMapping("/player/")
    public List<Player> findBy(){
        return playerRepository.findAll();
    }

    @GetMapping("/player/{username}")
    public Player findByUsername(@PathVariable String username){
        return playerRepository.findByUsername(username);
    }

    @PostMapping("/player/")
    public Player newPlayer(@RequestBody String username){
        return playerRepository.save(new Player(username));
    }

    @PostMapping("/player/new")
    public Player newPlayer(){
        return playerRepository.save(new Player("ss"));
    }

    @PostMapping("/crew/")
    public Member newMember(@RequestBody Member member){
        return memberService.hireMember(member);
    }

    @PostMapping("/building/")
    public Building addBuilding(@RequestBody Building building){
      return buildingService.build(building);
    }


    @SuppressWarnings("rawtypes")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Player player) {
        Player userExists = playerRepository.findByUsername(player.getUsername());
        if (userExists != null) {
            throw new BadCredentialsException("User with username: " + player.getUsername() + " already exists");
        }
        customUserDetailsService.savePlayer(player);
        Map<Object, Object> model = new HashMap<>();
        model.put("message", "User registered successfully");
        return ok(model);
    }
}
