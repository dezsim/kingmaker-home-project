package hu.flowacademy.kingmakerbackend.model.building;

import hu.flowacademy.kingmakerbackend.model.Player;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Building implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private BuildingType buildingType;

    @OneToOne
    private Player player;

    Building() {
    }

    public Building(BuildingType buildingType, Player player) {
        this.buildingType = buildingType;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

