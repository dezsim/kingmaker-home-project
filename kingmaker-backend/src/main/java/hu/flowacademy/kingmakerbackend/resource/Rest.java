package hu.flowacademy.kingmakerbackend.resource;

import hu.flowacademy.kingmakerbackend.logics.BuildingService;
import hu.flowacademy.kingmakerbackend.logics.MemberService;
import hu.flowacademy.kingmakerbackend.model.Player;
import hu.flowacademy.kingmakerbackend.model.building.*;
import hu.flowacademy.kingmakerbackend.model.crew.Member;
import hu.flowacademy.kingmakerbackend.model.game.GameModel;
import hu.flowacademy.kingmakerbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Rest {


    @Autowired
    private BuildingService buildingService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CrewRepository crewRepository;


    public Rest() {
    }


    @PostMapping("/game/")
    public GameModel newGame(@RequestParam("playerRed") String redname, @RequestParam("playerBlue") String bluename){
        var red = playerRepository.findByUsername(redname);
        var blue = playerRepository.findByUsername(bluename);
        var game = new GameModel(red, blue);
        return game;
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
    public Player newPlayer(@RequestBody String username, String password){
        return playerRepository.save(new Player(username, password));
    }

    @PostMapping("/player/new")
    public Player newPlayer(){
        return playerRepository.save(new Player("ss", "bb"));
    }

    @PostMapping("/player/crew/")
    public Member newMember(@RequestBody Member member){
        return memberService.hireMember(member);
    }

    @PostMapping("/building/")
    public Building addBuilding(@RequestBody Building building){
        return buildingService.build(building);
    }

    @GetMapping("/building/{id}")
    public Building findById(@PathVariable Long id){
       /* return buildingRepository.getOne(1L).getBuildingType().getBuildingInterest()*/;
        return buildingService.findById(id);
    }
}
