package hu.flowacademy.kingmakerbackend.models.crew;

public class Diplomat extends CrewMember {
    public Diplomat(Integer price, Integer prosperityLevel, Integer fameLevel, Integer secretsLevel) {
        super(price, prosperityLevel, fameLevel, secretsLevel);
        setExperience(0);
    }
}
