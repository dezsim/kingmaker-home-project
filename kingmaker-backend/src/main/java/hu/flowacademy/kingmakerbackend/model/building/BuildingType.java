package hu.flowacademy.kingmakerbackend.model.building;

public enum BuildingType {
    BANK("Bank", 65, 13),
    GOLDMINE("Goldmine", 80, 15),
    MARKETPLACE("Marketplace", 50, 10),
    VINEYARD("Vineyard", 30, 6);

    private final String buildingName;
    private final int buildingPrice;
    private final int buildingInterest;


    BuildingType(String buildingName, int buildingPrice, int buildingInterest) {
        this.buildingName = buildingName;
        this.buildingPrice = buildingPrice;
        this.buildingInterest = buildingInterest;
    }

    public static BuildingType fromText(String text){
        for(BuildingType bT : BuildingType.values()){
            if(bT.getBuildingName().equals(text)){
                return bT;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public int getBuildingPrice() {
        return buildingPrice;
    }

    public int getBuildingInterest() {
        return buildingInterest;
    }



}
