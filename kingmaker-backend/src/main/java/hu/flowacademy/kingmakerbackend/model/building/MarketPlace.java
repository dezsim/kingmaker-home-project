package hu.flowacademy.kingmakerbackend.model.building;

public class MarketPlace extends Building {

    public MarketPlace() {
        super(50, 10);
    }

    public MarketPlace(Integer buildingPrice, Integer buildingInterest) {
        super(buildingPrice, buildingInterest);
    }
}
