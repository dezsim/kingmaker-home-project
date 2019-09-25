package hu.flowacademy.kingmakerbackend.logics;

import hu.flowacademy.kingmakerbackend.model.Player;
import hu.flowacademy.kingmakerbackend.model.crew.Member;
import hu.flowacademy.kingmakerbackend.model.crew.MemberType;
import hu.flowacademy.kingmakerbackend.repository.CrewRepository;
import hu.flowacademy.kingmakerbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MemberService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CrewRepository crewRepository;

    public Member hireMember(Member member){
        Player player = playerRepository.findById(member.getPlayer().getId()).get();
        if( player.getGold() >= member.getMemberPrice() && player.getCrewSize() < 7 && canHireThisType(member, player)) {
            player.setGold(player.getGold() - member.getMemberPrice());
            player.setCrewSize(player.getCrewSize() + 1);
            return crewRepository.save(member);
        } else {
            throw new IllegalArgumentException("A crew mérete nem lehet nagyobb, mint 7 és nem lehet ugyanazon típusú csapattagból több, mint 3");
        }
    }

    private boolean canHireThisType(Member member, Player player){
        return (player.getMember().stream().filter(m -> m.getMemberType().equals(member.getMemberType())).count() < 3);
    }
}
