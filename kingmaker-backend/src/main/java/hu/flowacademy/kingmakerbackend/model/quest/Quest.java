package hu.flowacademy.kingmakerbackend.model.quest;

import hu.flowacademy.kingmakerbackend.model.crew.MemberType;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Quest {

   private Long id = 0L;
   private int successChance;
   private int xpGain;
   private QuestType questType;

    public Quest(QuestType questType) {
        this.questType = questType;
        this.successChance = questType.getSuccessChance();
        this.xpGain = new Random().nextInt(15) + 1;
        this.id++;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public QuestType getQuestType() {
        return questType;
    }

    public void setQuestType(QuestType questType) {
        this.questType = questType;
    }
}
