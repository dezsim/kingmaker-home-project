package hu.flowacademy.kingmakerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.flowacademy.kingmakerbackend.model.building.Building;

import javax.persistence.*;

@Entity
@Table
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private Integer gold;

    @Column
    private Integer MP;

    @Column
    private Integer DP;

    @JsonIgnore
    @OneToOne(mappedBy = "player")
    private Building building;

    public Player() {
    }

    public Player(String username) {
        this.username = username;
        this.gold = 180;
        this.DP = 40;
        this.MP = 0;
    }

    public Player(String username, Integer gold, Integer DP, Integer MP) {
        this.username = username;
        this.gold = gold;
        this.DP = DP;
        this.MP = MP;
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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }


}
