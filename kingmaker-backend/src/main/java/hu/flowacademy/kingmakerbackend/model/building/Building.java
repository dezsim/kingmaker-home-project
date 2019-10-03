package hu.flowacademy.kingmakerbackend.model.building;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.flowacademy.kingmakerbackend.model.Player;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Building implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private BuildingType buildingType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "player_id")
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

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", buildingType=" + buildingType +
                '}';
    }
}

