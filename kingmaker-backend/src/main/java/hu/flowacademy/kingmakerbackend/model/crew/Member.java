package hu.flowacademy.kingmakerbackend.model.crew;

import hu.flowacademy.kingmakerbackend.model.Player;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private Integer memberPrice;

    @Column
    private Integer prosperityLevel;

    @Column
    private Integer fameLevel;

    @Column
    private Integer secretsLevel;

    @Column
    private Integer experience;

    @Column
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;

    Member(){
        this.memberPrice = 10;
        this.prosperityLevel = 0;
        this.fameLevel = 0;
        this.secretsLevel = 0;
        this.experience = 0;
    }

    public Member(MemberType memberType, Player player) {
        this.memberType = memberType;
        this.player = player;
        this.memberPrice = 10;
        this.prosperityLevel = 0;
        this.fameLevel = 0;
        this.secretsLevel = 0;
        this.experience = 0;
    }

    public Member(Integer memberPrice, Integer prosperityLevel, Integer fameLevel, Integer secretsLevel, Integer experience, MemberType memberType, Player player) {
        this.memberPrice = memberPrice;
        this.prosperityLevel = prosperityLevel;
        this.fameLevel = fameLevel;
        this.secretsLevel = secretsLevel;
        this.experience = experience;
        this.memberType = memberType;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
