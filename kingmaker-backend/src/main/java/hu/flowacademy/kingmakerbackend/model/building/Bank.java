package hu.flowacademy.kingmakerbackend.model.building;

public class Bank extends Building {
    private final Integer bankPrice = 65;
    private final Integer bankInterest = 13;

    public Bank() {
        super(65, 13);
    }

    public Bank(Integer buildingPrice, Integer buildingInterest) {
        super(buildingPrice, buildingInterest);
    }
}
