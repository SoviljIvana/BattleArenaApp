package rs.devcenter.battlearena.fight;

public class Hero2 extends Thread {

    Fight fight;

    public Hero2(Fight b) {
        fight = b;
    }

    @Override
    public void run() {
        int criticalChance2 = fight.randomCriticalChance();
        if (fight.opponentName == "Mage") {
            if (fight.fighterName == "Priest") {
                if (criticalChance2 >= 30) {
                    while (fight.getMageFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentHealth() > 0 && fight.getPriestFighter().getCurrentHealth() > 0) {
                            fight.opponentMove();
                    }
                } else {
                    while (fight.getMageFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentHealth() > 0 && fight.getPriestFighter().getCurrentHealth() > 0) {
                            fight.opponentMove();
                    }
                }
            } else if (fight.fighterName == "Warrior") {
                if (criticalChance2 >= 30) {
                    while (fight.getMageFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentHealth() > 0 && fight.getWarriorFighter().getCurrentHealth() > 0) {
                            fight.opponentMove();
                    }
                } else {
                    while (fight.getMageFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentHealth() > 0 && fight.getWarriorFighter().getCurrentHealth() > 0) {
                            fight.opponentMove();
                    }
                }
            }
        } else if (fight.opponentName == "Priest") {
            if (fight.fighterName == "Mage") {
                if (criticalChance2 >= 30) {
                    while (fight.getPriestFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentHealth() > 0 && fight.getMageFighter().getCurrentHealth() > 0) {
                            fight.opponentMove();
                    }
                } else {
                    while (fight.getPriestFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentHealth() > 0 && fight.getMageFighter().getCurrentHealth() > 0) {
                            fight.opponentMove();
                    }
                }
            } else if (fight.fighterName == "Warrior") {
                if (criticalChance2 >= 30) {
                    while (fight.getPriestFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentHealth() > 0 && fight.getWarriorFighter().getCurrentHealth() > 0) {
                            fight.opponentMove();
                    }
                } else {
                    while (fight.getPriestFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentHealth() > 0 && fight.getWarriorFighter().getCurrentHealth() > 0) {
                            fight.opponentMove();
                    }
                }
            }
        } else {
            if (fight.fighterName == "Mage") {
                if (criticalChance2 >= 30) {
                    while (fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentHealth() > 0 && fight.getMageFighter().getCurrentHealth() > 0) {
                            fight.opponentMove();
                    }
                } else {
                    while (fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentHealth() > 0 && fight.getMageFighter().getCurrentHealth() > 0) {
                            fight.opponentMove();
                    }
                }
            } else if (fight.fighterName == "Priest") {
                if (criticalChance2 >= 30) {
                    while (fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentHealth() > 0 && fight.getPriestFighter().getCurrentHealth() > 0) {

                            fight.opponentMove();
                    }
                } else {
                    while (fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentHealth() > 0 && fight.getPriestFighter().getCurrentHealth() > 0) {

                            fight.opponentMove();
                    }
                }
            }
        }
    }
}