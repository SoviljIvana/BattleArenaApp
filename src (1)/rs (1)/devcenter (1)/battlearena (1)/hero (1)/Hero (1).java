package rs.devcenter.battlearena.hero;

import rs.devcenter.battlearena.spells.Spells;

public abstract class Hero {

    private String heroName;
    private int heroMaxXP;
    private int currentXP, currentHealth, currentPower, criticalChance, maxPower, maxHealth, minBaseDamage, maxBaseDamage;
    private Spells spell1, spell2, spell3;
    private static int maxLevel = 5;
    private int currentLevel;

    public int getMinBaseDamage() {
        return minBaseDamage;
    }

    public void setMinBaseDamage(int minBaseDamage) {
        this.minBaseDamage = minBaseDamage;
    }

    public int getMaxBaseDamage() {
        return maxBaseDamage;
    }

    public void setMaxBaseDamage(int maxBaseDamage) {
        this.maxBaseDamage = maxBaseDamage;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }


    public void setHeroMaxXP(int heroMaxXP) {
        this.heroMaxXP = heroMaxXP;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentXP() {
        return currentXP;
    }

    public void setCurrentXP(int currentXP) {
        this.currentXP = currentXP;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getCurrentPower() {
        return currentPower;
    }

    public void setCurrentPower(int currentPower) {
        this.currentPower = currentPower;
    }

    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }

    public Spells getSpell1() {
        return spell1;
    }

    public void setSpell1(Spells spell1) {
        this.spell1 = spell1;
    }

    public Spells getSpell2() {
        return spell2;
    }

    public void setSpell2(Spells spell2) {
        this.spell2 = spell2;
    }

    public Spells getSpell3() {
        return spell3;
    }

    public void setSpell3(Spells spell3) {
        this.spell3 = spell3;
    }

}

