package hu.flowacademy.kingmakerbackend.repository;

import hu.flowacademy.kingmakerbackend.model.crew.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CrewRepository extends JpaRepository<Member, Long> {
   /* private Integer crewSize;
    private Integer playerId;
    private List<Member> crewList;

    public CrewRepository() {
    }

    public CrewRepository(Integer playerId) {
        this.playerId = playerId;
        this.crewSize = 7;
        this.crewList = new ArrayList<>();
    }

    public Integer getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(Integer crewSize) {
        this.crewSize = crewSize;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public List<Member> getCrewList() {
        return crewList;
    }

    public void setCrewList(List<Member> crewList) {
        this.crewList = crewList;
    }*/
}
