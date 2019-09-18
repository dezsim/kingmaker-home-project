package hu.flowacademy.kingmakerbackend.model;

import hu.flowacademy.kingmakerbackend.model.crew.MemberType;

import java.util.List;

public class Quest {

    private String questName;
    private int chanceToSuccess;
    private List<MemberType> neededMember;
    private List<MemberType> extraChanceMember;
    private String result;

    public Quest() {
    }

    public Quest(String questName, int chanceToSuccess, List<MemberType> neededMember, List<MemberType> extraChanceMember, String result) {
        this.questName = questName;
        this.chanceToSuccess = chanceToSuccess;
        this.neededMember = neededMember;
        this.extraChanceMember = extraChanceMember;
        this.result = result;
    }

    public String getQuestName() {
        return questName;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }

    public int getChanceToSuccess() {
        return chanceToSuccess;
    }

    public void setChanceToSuccess(int chanceToSuccess) {
        this.chanceToSuccess = chanceToSuccess;
    }

    public List<MemberType> getNeededMember() {
        return neededMember;
    }

    public void setNeededMember(List<MemberType> neededMember) {
        this.neededMember = neededMember;
    }

    public List<MemberType> getExtraChanceMember() {
        return extraChanceMember;
    }

    public void setExtraChanceMember(List<MemberType> extraChanceMember) {
        this.extraChanceMember = extraChanceMember;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
