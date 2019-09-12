package hu.flowacademy.kingmakerbackend.models.buildings;

public abstract class Building {
    private Integer buildingPrice;

    Building() {
    }

    public Integer getBuildingPrice() {
        return buildingPrice;
    }

    void setBuildingPrice(Integer buildingPrice) {
        this.buildingPrice = buildingPrice;
    }
}
