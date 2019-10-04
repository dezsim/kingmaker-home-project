package hu.flowacademy.kingmakerbackend.logics;

import hu.flowacademy.kingmakerbackend.model.Player;
import hu.flowacademy.kingmakerbackend.model.crew.Member;
import hu.flowacademy.kingmakerbackend.model.crew.MemberType;
import hu.flowacademy.kingmakerbackend.repository.CrewRepository;
import hu.flowacademy.kingmakerbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
@Transactional
public class MemberService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CrewRepository crewRepository;

    private ResponseStatusException CREW_EXC = new ResponseStatusException(HttpStatus.NOT_FOUND, "Crew size or gold ");

    public Member hireMember(Member member){
        Player player = playerRepository.findByUsername(member.getPlayer().getUsername());
        if( player.getGold() >= member.getMemberPrice() && player.getCrewSize() < 7 && canHireThisType(member, player)) {
            player.setGold(player.getGold() - member.getMemberPrice());
            player.setCrewSize(player.getCrewSize() + 1);
            return crewRepository.save(new Member(member.getMemberType(),player));
        } else {
            throw CREW_EXC;
        }
    }

    private boolean canHireThisType(Member member, Player player){
        return (player.getMember().stream().filter(m -> m.getMemberType().equals(member.getMemberType())).count() < 3);
    }
}
