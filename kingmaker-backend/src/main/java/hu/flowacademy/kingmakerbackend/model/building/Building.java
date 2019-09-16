package hu.flowacademy.kingmakerbackend.model.building;

import hu.flowacademy.kingmakerbackend.model.Player;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public abstract class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer buildingPrice;

    @Column
    private Integer buildingInterest;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private BuildingType buildingType;

    @ManyToMany
    private Player player;

    Building() {
    }

    public Building(Integer buildingPrice, Integer buildingInterest) {
        this.buildingPrice = buildingPrice;
        this.buildingInterest = buildingInterest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBuildingPrice() {
        return buildingPrice;
    }

    void setBuildingPrice(Integer buildingPrice) {
        this.buildingPrice = buildingPrice;
    }

    public Integer getBuildingInterest() {
        return buildingInterest;
    }

    public void setBuildingInterest(Integer buildingInterest) {
        this.buildingInterest = buildingInterest;
    }
}

