package hu.flowacademy.kingmakerbackend.model.quest;

import hu.flowacademy.kingmakerbackend.model.crew.MemberType;

import java.util.List;



public enum QuestType {
    CON("Con", 5, List.of(MemberType.THIEF, MemberType.DIPLOMAT)),
    AMBUSH("Ambush", 5, List.of(MemberType.WARRIOR)),
    ASSASINATE("Assasinate", 5, List.of(MemberType.WARRIOR, MemberType.WARRIOR)),
    ROB("Rob", 5, List.of(MemberType.THIEF, MemberType.WARRIOR)),
    SUE("Sue", 30, List.of(MemberType.DIPLOMAT, MemberType.DIPLOMAT)),
    DEFEND("Defend", 35, List.of(MemberType.WARRIOR)),
    BRIBE("Bribe", 30, List.of(MemberType.DIPLOMAT)),
    SPREADRUMORS("Spread Rumors",30, List.of()),
    HOSTPARTY("Host Party", 45, List.of(MemberType.DIPLOMAT)),
    PRAISE("Praise", 45, List.of()),
    HEAL("Heal", 65, List.of()),
    MAKEMONEY("Make Money", 40, List.of(MemberType.DIPLOMAT, MemberType.THIEF)),
    SPY("Spy", 40, List.of(MemberType.THIEF));

    private final String type;
    private final int successChance;
    private final List<MemberType> crewRequirements;

    QuestType(String type, int successChance, List<MemberType> crewRequirements){
        this.type = type;
        this.successChance = successChance;
        this.crewRequirements = crewRequirements;
    }

    public static QuestType fromText(String text){
        for(QuestType questType : QuestType.values()){
            if(questType.getType().equals(text)){
                return questType;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getType() {
        return type;
    }

    public int getSuccessChance() {
        return successChance;
    }

    public List<MemberType> getCrewRequirements() {
        return crewRequirements;
    }
}

