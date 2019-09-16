package hu.flowacademy.kingmakerbackend.models.buildings;

public abstract class Building {
    private Integer buildingPrice;
    private Integer buildingInterest;

    Building() {
    }

    public Building(Integer buildingPrice, Integer buildingInterest) {
        this.buildingPrice = buildingPrice;
        this.buildingInterest = buildingInterest;
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
