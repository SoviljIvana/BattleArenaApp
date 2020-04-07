package rs.devcenter.battlearena.fight;

public class Hero1 extends Thread {

    Fight fight;

    public Hero1(Fight b) {
        fight = b;
    }

    @Override
    public void run() {

        int criticalChance1 = fight.randomCriticalChance();

        if (fight.fighterName == "Mage") {
            if (fight.opponentName == "Priest") {
                if (criticalChance1 >= 30) {
                    while (fight.getMageFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentHealth() > 0 && fight.getPriestFighter().getCurrentHealth() > 0) {
                            fight.playerMove();
                    }
                } else {
                    while (fight.getMageFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentHealth() > 0 && fight.getPriestFighter().getCurrentHealth() > 0) {
                            fight.playerMove();
                    }
                }
            } else if (fight.opponentName == "Warrior") {
                if (criticalChance1 >= 30) {
                    while (fight.getMageFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentHealth() > 0 && fight.getWarriorFighter().getCurrentHealth() > 0) {
                            fight.playerMove();
                    }
                } else {
                    while (fight.getMageFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentHealth() > 0 && fight.getWarriorFighter().getCurrentHealth() > 0) {
                            fight.playerMove();
                    }
                }
            }
        } else if (fight.fighterName == "Priest") {
            if (fight.opponentName == "Mage") {
                if (criticalChance1 >= 30) {
                    while (fight.getPriestFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentHealth() > 0 && fight.getMageFighter().getCurrentHealth() > 0) {
                            fight.playerMove();
                    }
                } else {
                    while (fight.getPriestFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentHealth() > 0 && fight.getMageFighter().getCurrentHealth() > 0) {
                            fight.playerMove();
                    }
                }
            } else if (fight.opponentName == "Warrior") {
                if (criticalChance1 >= 30) {
                    while (fight.getPriestFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentHealth() > 0 && fight.getWarriorFighter().getCurrentHealth() > 0) {
                            fight.playerMove();
                    }
                } else {
                    while (fight.getPriestFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentHealth() > 0 && fight.getWarriorFighter().getCurrentHealth() > 0) {
                            fight.playerMove();
                    }
                }
            }
        } else {
            if (fight.opponentName == "Mage") {
                if (criticalChance1 >= 30) {
                    while (fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentHealth() > 0 && fight.getMageFighter().getCurrentHealth() > 0) {
                            fight.playerMove();
                    }
                } else {
                    while (fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getMageFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentHealth() > 0 && fight.getMageFighter().getCurrentHealth() > 0) {
                            fight.playerMove();
                    }
                }
            } else if (fight.opponentName == "Priest") {
                if (criticalChance1 >= 30) {
                    while (fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentHealth() > 0 && fight.getPriestFighter().getCurrentHealth() > 0) {
                            fight.playerMove();
                    }
                } else {
                    while (fight.getWarriorFighter().getCurrentPower() >= 0 && fight.getPriestFighter().getCurrentPower() >= 0 && fight.getWarriorFighter().getCurrentHealth() > 0 && fight.getPriestFighter().getCurrentHealth() > 0) {
                            fight.playerMove();
                    }
                }
            }
        }
    }
}

