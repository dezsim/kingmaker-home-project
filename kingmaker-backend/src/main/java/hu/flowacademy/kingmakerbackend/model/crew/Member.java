package hu.flowacademy.kingmakerbackend.model.crew;

public class Member {
    private Integer memberPrice;
    private Integer prosperityLevel;
    private Integer fameLevel;
    private Integer secretsLevel;
    private Integer experience;

    public Member() {
        this.memberPrice = 10;
        this.prosperityLevel = 0;
        this.fameLevel = 0;
        this.secretsLevel = 0;
        this.experience = 0;
    }

    public Member(Integer memberPrice, Integer prosperityLevel, Integer fameLevel, Integer secretsLevel, Integer experience) {
        this.memberPrice = memberPrice;
        this.prosperityLevel = prosperityLevel;
        this.fameLevel = fameLevel;
        this.secretsLevel = secretsLevel;
        this.experience = experience;
    }

    public Integer getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(Integer memberPrice) {
        this.memberPrice = memberPrice;
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

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }
}
