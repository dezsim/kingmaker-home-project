package hu.flowacademy.kingmakerbackend.resource;

import hu.flowacademy.kingmakerbackend.logics.BuildingService;
import hu.flowacademy.kingmakerbackend.logics.MemberService;
import hu.flowacademy.kingmakerbackend.model.Player;
import hu.flowacademy.kingmakerbackend.model.building.*;
import hu.flowacademy.kingmakerbackend.model.crew.Member;
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
    private BuildingRepository buildingRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CrewRepository crewRepository;


    public Rest() {
    }

    @GetMapping("")
    public int base(){
        System.out.println("connected");
        return 1;
    }

    @GetMapping("/player/")
    public List<Player> findBy(){
        return playerRepository.findAll();
    }

    @PostMapping("/player/")
    public Player newPlayer(@RequestParam("username") String username){
        return playerRepository.save(new Player(username));
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
        return buildingRepository.findById(id).orElse(null);
    }
}
