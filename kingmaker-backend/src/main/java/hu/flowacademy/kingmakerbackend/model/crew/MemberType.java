package hu.flowacademy.kingmakerbackend.model.crew;

public enum  MemberType {
    DIPLOMAT("Diplomat"),
    THIEF("Thief"),
    WARRIOR("Warrior");

    private final String type;

    MemberType(String type) {
        this.type = type;
    }

    public static MemberType fromText(String text){
        for(MemberType mT : MemberType.values()){
            if(mT.getType().equals(text)){
                return mT;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getType() {
        return type;
    }
}
