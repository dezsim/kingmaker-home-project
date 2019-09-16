package hu.flowacademy.kingmakerbackend.models.crew;

import javax.persistence.criteria.CriteriaBuilder;

public abstract class CrewMember {
    private Integer price;
    private Integer prosperityLevel;
    private Integer fameLevel;
    private Integer secretsLevel;
    private Integer experience;

    CrewMember(Integer price, Integer prosperityLevel, Integer fameLevel, Integer secretsLevel) {
        this.price = price;
        this.prosperityLevel = prosperityLevel;
        this.fameLevel = fameLevel;
        this.secretsLevel = secretsLevel;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getProsperityLevel() {
        return prosperityLevel;
    }

    public void setProsperityLevel(Integer prosperityLevel) {
        this.prosperityLevel = prosperityLevel;
    }

    public Integer getFameLevel() {
        return fameLevel;
    }

    public void setFameLevel(Integer fameLevel) {
        this.fameLevel = fameLevel;
    }

    public Integer getSecretsLevel() {
        return secretsLevel;
    }

    public void setSecretsLevel(Integer secretsLevel) {
        this.secretsLevel = secretsLevel;
    }
}
