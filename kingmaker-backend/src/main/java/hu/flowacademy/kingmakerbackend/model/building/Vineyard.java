package hu.flowacademy.kingmakerbackend.model.building;

public class Vineyard extends Building {

    public Vineyard() {
    super(30, 6);
    }

    public Vineyard(Integer buildingPrice, Integer buildingInterest) {
        super(buildingPrice, buildingInterest);
    }
}
