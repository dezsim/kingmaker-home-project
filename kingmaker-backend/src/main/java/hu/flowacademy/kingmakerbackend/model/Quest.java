package hu.flowacademy.kingmakerbackend.model;

import hu.flowacademy.kingmakerbackend.model.crew.MemberType;

import java.util.List;

public class Quest {

   private Long id;
   private String type;
   private int successChance;
   private int xpGain;

    public Quest(String type) {                         //Mocking quests
        this.successChance = getQuestData().get(0);
        this.xpGain = getQuestData().get(1);
        this.id = id;
    }

    private List<Integer> getQuestData() {
        return List.of(10, 5);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSuccessChance() {
        return successChance;
    }

    public void setSuccessChance(int successChance) {
        this.successChance = successChance;
    }

    public int getXpGain() {
        return xpGain;
    }

    public void setXpGain(int xpGain) {
        this.xpGain = xpGain;
    }
}
