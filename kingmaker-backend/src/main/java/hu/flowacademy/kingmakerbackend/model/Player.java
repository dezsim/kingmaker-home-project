package hu.flowacademy.kingmakerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.flowacademy.kingmakerbackend.model.building.Building;
import hu.flowacademy.kingmakerbackend.model.crew.Member;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private Integer gold;

    @Column
    private Integer MP;

    @Column
    private Integer DP;

    @Column
    private Integer crewSize;

    @Column
    private String role;


 /*   @JsonIgnore
    @OneToOne(mappedBy = "player")
    private Building building;*/

    @OneToMany(mappedBy="player")
    private List<Building> building;

    @OneToMany(mappedBy = "player")
    private List<Member> member;

    public Player() {
    }

    public Player(String username) {
        this.username = username;
        this.password = "anyád";
        this.member = new ArrayList<>();
        this. building = new ArrayList<>();
        this.gold = 180;
        this.DP = 40;
        this.MP = 0;
        this.crewSize = 0;
        this.role = "USER";
    }

    public Player(String username, Integer gold, Integer DP, Integer MP, Integer crewSize) {
        this.username = username;
        this.member = new ArrayList<>();
        this. building = new ArrayList<>();
        this.gold = gold;
        this.DP = DP;
        this.MP = MP;
        this.crewSize = crewSize;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getMP() {
        return MP;
    }

    public void setMP(Integer MP) {
        this.MP = MP;
    }

    public Integer getDP() {
        return DP;
    }

    public void setDP(Integer DP) {
        this.DP = DP;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(Integer crewSize) {
        this.crewSize = crewSize;
    }

    public List<Building> getBuilding() {
        return building;
    }

    public void setBuilding(List<Building> building) {
        this.building = building;
    }

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
