package hu.flowacademy.kingmakerbackend.models;

public class Player {
    private Integer gold;
    private Integer MP;
    private Integer DP;

    public Player(Integer gold, Integer DP, Integer MP) {
        this.gold = gold;
        this.DP = DP;
        this.MP = MP;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getMP() {
        return MP;
    }

    public void setMP(Integer MP) {
        this.MP = MP;
    }

    public Integer getDP() {
        return DP;
    }

    public void setDP(Integer DP) {
        this.DP = DP;
    }
}
