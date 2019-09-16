package hu.flowacademy.kingmakerbackend.model.building;

public class GoldMine extends Building{

    public GoldMine() {
        super(80, 15);
    }

    public GoldMine(Integer buildingPrice, Integer buildingInterest) {
        super(buildingPrice, buildingInterest);
    }
}
