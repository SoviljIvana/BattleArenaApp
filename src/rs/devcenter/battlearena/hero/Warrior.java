package rs.devcenter.battlearena.hero;

public class Warrior extends Hero {

    public Warrior() {
        this.setHeroName("Warrior");
        this.setCriticalChance(0);
        this.setMaxPower(100);
        this.setMaxHealth(100);
        this.setCurrentLevel(1);
        this.setCurrentXP(0);
        this.setCurrentHealth(100);
        this.setCurrentPower(100);
        this.setHeroMaxXP(50);
        this.setMinBaseDamage(2);
        this.setMaxBaseDamage(6);
    }
}

