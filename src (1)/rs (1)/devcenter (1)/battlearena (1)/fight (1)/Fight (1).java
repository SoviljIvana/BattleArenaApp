package rs.devcenter.battlearena.fight;

import rs.devcenter.battlearena.arena.Arena;
import rs.devcenter.battlearena.arena.BasicArena;
import rs.devcenter.battlearena.arena.IceArena;
import rs.devcenter.battlearena.arena.KillerArena;
import rs.devcenter.battlearena.battleMode.BattleMode;
import rs.devcenter.battlearena.battleMode.EpicenterBattleMode;
import rs.devcenter.battlearena.battleMode.StandardBattleMode;
import rs.devcenter.battlearena.hero.Hero;
import rs.devcenter.battlearena.hero.Mage;
import rs.devcenter.battlearena.hero.Priest;
import rs.devcenter.battlearena.hero.Warrior;
import rs.devcenter.battlearena.spells.*;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Fight {

    private Scanner obj = new Scanner(System.in);
    private Random randomNum = new Random();
    static Semaphore fighter1 = new Semaphore(0), fighter2 = new Semaphore(1);
    private Arena basicArena = new BasicArena(), killerArena = new KillerArena(), iceArena = new IceArena();
    private Spells baseAttack = new BaseAttack(), magicAttack = new MagicAttack(), powerfulAttack = new PowerfulAttack(), quickAttack = new QuickAttack();
    private BattleMode epicenter = new EpicenterBattleMode(), standard = new StandardBattleMode();
    private Hero mageFighter = new Mage(), priestFighter = new Priest(), warriorFighter = new Warrior();
    private String hero1, hero2;
    public String fighterName = hero1Name(), opponentName = hero2Name();
    public int battleMode = 0;
    private String mode = battleMode();
    private int arena = 0;

    /**
     * This method returns the name of the arena the fighter selected
     *
     * @return (baseArena or killerArena or iceArena)
     * default- basicArena
     */
    public String arenaName() {

        System.out.println("\u001B[31m" + "\nCHOOSE ARENA:\n \u001B[32m" + "\t1. Basic Arena \n \u001B[30m" + "\t2. Killer Arena \n \u001B[34m" + "\t3. Ice Arena\n");
        System.out.println("\u001B[31m" + "I choose arena number:");
        String wantArena = obj.nextLine();
        switch (wantArena) {
            case "1":
                arena = 1;
                return basicArena.getArenaName();
            case "2":
                arena = 2;
                return killerArena.getArenaName();
            case "3":
                arena = 3;
                return iceArena.getArenaName();
            default:
                arena = 1;
                return basicArena.getArenaName();
        }
    }

    /**
     * This method returns the name of the hero the fighter selected
     *
     * @return (mage or priest or warrior)
     * default- priest
     */
    public String hero1Name() {
        System.out.println("\u001B[31m" + "CHOOSE HERO:\n\u001B[32m" + "\t1. Mage\n\u001B[30m" + "\t2. Priest\n\u001B[34m" + "\t3. Warrior");
        System.out.println("\u001B[31m" + "I choose hero number: ");
        String wantHero = obj.nextLine();
        switch (wantHero) {
            case "1":
                hero1 = mageFighter.getHeroName();
                return hero1;
            case "2":
                hero1 = priestFighter.getHeroName();
                return hero1;
            case "3":
                hero1 = warriorFighter.getHeroName();
                return hero1;
            default:
                return priestFighter.getHeroName();
        }
    }

    /**
     * This method returns the opponent's name (random selection)
     *
     * @return (mage or priest or warrior)
     */
    public String hero2Name() {
        for (; ; ) {
            int randomNumber = ((int) (Math.random() * 10));
            if ((hero1 == "priest" || hero1 == "Warrior") && randomNumber == 1) {
                hero2 = mageFighter.getHeroName();
                return hero2;
            } else if ((hero1 == "Mage" || hero1 == "Warrior") && randomNumber == 2) {
                hero2 = priestFighter.getHeroName();
                return hero2;
            } else if ((hero1 == "Mage" || hero1 == "Priest") && randomNumber == 3) {
                hero2 = warriorFighter.getHeroName();
                return hero2;
            }
        }
    }

    /**
     * This method returns the name of the battleMode that the fighter selected
     *
     * @return (epicenter or standard)
     */
    public String battleMode() {
        System.out.println("\u001B[31m" + "\nCHOOSE BATTLE MODE:\n \u001B[32m" + "\t1. Standard Battle Mode (you VS computer)\n \u001B[30m" + "\t2. Epicenter Battle Mode (you VS someone)");
        System.out.println("\u001B[31m" + "I choose battle mode: ");
        String wantBattleMode = obj.nextLine();
        switch (wantBattleMode) {
            case "1":
                battleMode = 1;
                return standard.getBattleModeName();
            case "2":
                battleMode = 2;
                return epicenter.getBattleModeName();
            default:
                battleMode = 1;
                return standard.getBattleModeName();
        }
    }

    /**
     * this method prints player statistics(level, currentXP, currentHealth, currentPower, spells)
     *
     * @param hero1 -fighter1(mage or priest or warrior)
     * @param hero2 -fighter2(mage or priest or warrior)
     */
    public void print(Hero hero1, Hero hero2) {
        System.out.println("\u001B[30m" + "\t\t\t\t\t\t" + hero1.getHeroName() + "\t\t\t\t\t\t\t\t" + hero2.getHeroName());
        System.out.println("\u001B[35m" + "LEVEL: " + "\t\t\t\t\t " + "\u001B[34m" + hero1.getCurrentLevel() + "    \t\t\t\t\t\t\t\t " + "\u001B[32m" + hero2.getCurrentLevel());
        System.out.println("\u001B[35m" + "CURRENT XP:" + "\t\t\t\t " + "\u001B[34m" + hero1.getCurrentXP() + " \t\t\t\t\t\t\t\t\t " + "\u001B[32m" + hero2.getCurrentXP());
        System.out.println("\u001B[35m" + "CURRENT HEALTH: " + "\t\t " + "\u001B[34m" + hero1.getCurrentHealth() + "     \t\t\t\t\t\t\t " + "\u001B[32m" + hero2.getCurrentHealth());
        System.out.println("\u001B[35m" + "CURRENT POWER: " + "\t\t\t " + "\u001B[34m" + hero1.getCurrentPower() + "  \t\t\t\t\t\t\t\t " + "\u001B[32m" + hero2.getCurrentPower());
        System.out.println("\u001B[35m" + "SPELLS: " + "\t\t\t " + "\u001B[34m" + hero1.getSpell1().getSpellName() + "/" + hero1.getSpell2().getSpellName() + "/" + hero1.getSpell3().getSpellName() + " \t " + "\u001B[32m" + hero2.getSpell1().getSpellName() + "/" + hero2.getSpell2().getSpellName() + "/" + hero2.getSpell3().getSpellName());
    }

    /**
     * This method returns a random number
     *
     * @return (number from 0 to 40)
     */
    public int randomCriticalChance() {
        int max = 40;
        int min = 1;
        int criticalChance = min + randomNum.nextInt(max);
        return criticalChance;
    }

    /**
     * This method allows the player to make a move
     */
    void playerMove() {

        try {

            Thread.sleep(2000);
            fighter1.acquire();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        if (fighterName == mageFighter.getHeroName()) {
            chooseSpellHero1(mageFighter);
        } else if (fighterName == priestFighter.getHeroName()) {
            chooseSpellHero1(priestFighter);
        } else {
            chooseSpellHero1(warriorFighter);
        }
        fighter2.release();
    }

    /**
     * This method allows the opponent to make a move
     */
    void opponentMove() {
        try {
            Thread.sleep(2000);
            fighter2.acquire();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        if (opponentName == mageFighter.getHeroName()) {
            chooseSpellHero2(mageFighter);
        } else if (opponentName == priestFighter.getHeroName()) {
            chooseSpellHero2(priestFighter);
        } else {
            chooseSpellHero2(warriorFighter);
        }
        fighter1.release();
    }

    /**
     * This methods checks the opponent's health and reduces it
     *
     * @param hero1
     * @param opponent
     */
    public void checkCriticalChanceHero1(Hero hero1, Hero opponent, int spell) {

        if (spell == 1) {
            if (opponent.getCurrentHealth() >= baseAttack.getMinDamage()) {
                opponent.setCurrentHealth(opponent.getCurrentHealth() - baseAttack.getMinDamage());
            } else if (opponent.getCurrentHealth() >= baseAttack.getMaxDamage()) {
                opponent.setCurrentHealth(opponent.getCurrentHealth() - baseAttack.getMaxDamage());
            }
        } else if (spell == 2) {
            if (opponent.getCurrentHealth() >= magicAttack.getMinDamage()) {
                opponent.setCurrentHealth(opponent.getCurrentHealth() - magicAttack.getMinDamage());
            } else if (opponent.getCurrentHealth() >= magicAttack.getMaxDamage()) {
                opponent.setCurrentHealth(opponent.getCurrentHealth() - magicAttack.getMaxDamage());
            }
        } else if (spell == 3) {
            if (opponent.getCurrentHealth() >= powerfulAttack.getMinDamage()) {
                opponent.setCurrentHealth(opponent.getCurrentHealth() - powerfulAttack.getMinDamage());
            } else if (opponent.getCurrentHealth() >= powerfulAttack.getMaxDamage()) {
                opponent.setCurrentHealth(opponent.getCurrentHealth() - powerfulAttack.getMaxDamage());
            }
        } else if (spell == 4) {
            if (opponent.getCurrentHealth() >= quickAttack.getMinDamage()) {
                opponent.setCurrentHealth(opponent.getCurrentHealth() - quickAttack.getMinDamage());
            } else if (opponent.getCurrentHealth() >= quickAttack.getMaxDamage()) {
                opponent.setCurrentHealth(opponent.getCurrentHealth() - quickAttack.getMaxDamage());
            }
        }
        if (opponent.getCurrentHealth() >= opponent.getMaxBaseDamage()) {
            opponent.setCurrentHealth(opponent.getCurrentHealth() - opponent.getMaxBaseDamage());

        } else if (opponent.getCurrentHealth() >= opponent.getMinBaseDamage()) {
            opponent.setCurrentHealth(opponent.getCurrentHealth() - opponent.getMinBaseDamage());
        }
        hero1.setCurrentXP(hero1.getCurrentXP() + 4);
        level(hero1);
        if (hero1.getCurrentLevel() == 2 || hero1.getCurrentLevel() == 3) {
            hero1.setCurrentHealth(hero1.getCurrentHealth() + 7);
        }
        if (hero1.getCurrentLevel() == 4 || hero1.getCurrentLevel() == 5) {
            hero1.setCurrentHealth(hero1.getCurrentHealth() - 7);
        }
        print(hero1, opponent);
    }

    /**
     * This methods checks the opponent's health and reduces it
     *
     * @param hero1
     * @param opponent
     */
    public void checkCriticalChanceHero2(Hero hero1, Hero opponent, int spell) {

        if (spell == 1) {
            if (hero1.getCurrentHealth() >= baseAttack.getMinDamage()) {
                hero1.setCurrentHealth(hero1.getCurrentHealth() - baseAttack.getMinDamage());
            } else if (hero1.getCurrentHealth() >= baseAttack.getMaxDamage()) {
                hero1.setCurrentHealth(hero1.getCurrentHealth() - baseAttack.getMaxDamage());
            }
        } else if (spell == 2) {
            if (hero1.getCurrentHealth() >= magicAttack.getMinDamage()) {
                hero1.setCurrentHealth(hero1.getCurrentHealth() - magicAttack.getMinDamage());
            } else if (hero1.getCurrentHealth() >= magicAttack.getMaxDamage()) {
                hero1.setCurrentHealth(hero1.getCurrentHealth() - magicAttack.getMaxDamage());
            }
        } else if (spell == 3) {
            if (hero1.getCurrentHealth() >= powerfulAttack.getMinDamage()) {
                hero1.setCurrentHealth(hero1.getCurrentHealth() - powerfulAttack.getMinDamage());
            } else if (hero1.getCurrentHealth() >= powerfulAttack.getMaxDamage()) {
                hero1.setCurrentHealth(hero1.getCurrentHealth() - powerfulAttack.getMaxDamage());
            }
        } else if (spell == 4) {
            if (hero1.getCurrentHealth() >= quickAttack.getMinDamage()) {
                hero1.setCurrentHealth(hero1.getCurrentHealth() - quickAttack.getMinDamage());
            } else if (hero1.getCurrentHealth() >= quickAttack.getMaxDamage()) {
                hero1.setCurrentHealth(hero1.getCurrentHealth() - quickAttack.getMaxDamage());
            }
        }
        if (hero1.getCurrentHealth() >= hero1.getMaxBaseDamage()) {
            hero1.setCurrentHealth(hero1.getCurrentHealth() - hero1.getMaxBaseDamage());
        } else if (hero1.getCurrentHealth() >= hero1.getMinBaseDamage()) {
            hero1.setCurrentHealth(hero1.getCurrentHealth() - hero1.getMinBaseDamage());
        }
        opponent.setCurrentXP(opponent.getCurrentXP() + 4);
        level(opponent);
        if (opponent.getCurrentLevel() == 2 || opponent.getCurrentLevel() == 3) {
            opponent.setCurrentHealth(opponent.getCurrentHealth() + 7);
        }
        if (opponent.getCurrentLevel() == 4 || opponent.getCurrentLevel() == 5) {
            opponent.setCurrentHealth(opponent.getCurrentHealth() - 7);
        }
        print(hero1, opponent);
    }

    /**
     * This method checks the opponent
     *
     * @param hero
     */
    public void checkYourOpponent(Hero hero, int spell) {
        if (hero2 == mageFighter.getHeroName()) {
            checkCriticalChanceHero1(hero, mageFighter, spell);
        } else if (hero2 == priestFighter.getHeroName()) {
            checkCriticalChanceHero1(hero, priestFighter, spell);
        } else if (hero2 == warriorFighter.getHeroName()) {
            checkCriticalChanceHero1(hero, warriorFighter, spell);
        }
    }

    /**
     * This method checks the opponent
     *
     * @param hero
     */
    public void theOpponentChecks(Hero hero, int spell) {
        if (hero1 == mageFighter.getHeroName()) {
            checkCriticalChanceHero2(mageFighter, hero, spell);
        } else if (hero1 == priestFighter.getHeroName()) {
            checkCriticalChanceHero2(priestFighter, hero, spell);
        } else if (hero1 == warriorFighter.getHeroName()) {
            checkCriticalChanceHero2(warriorFighter, hero, spell);
        }
    }

    /**
     * This method allows the player to select a spell
     *
     * @param hero
     */
    public void chooseSpellHero1(Hero hero) {

        if (arena == 2) {
            hero.setCurrentHealth(hero.getCurrentHealth() - 4);
        } else if (arena == 3) {
            hero.setCurrentHealth(hero.getCurrentHealth() - 2);
        }
        System.out.println("\u001B[34m" + "\nHERO 1:\n1.BASE ATTACK\n2.MAGIC ATTACK\n3.POWERFUL ATTACK\n4.QUICK ATTACK\n5.BUFF");
        String spell = obj.nextLine();
        switch (spell) {
            case "1":
                checkYourOpponent(hero, 1);
                break;
            case "2":
                if (hero.getHeroName() == priestFighter.getHeroName()) {
                    System.out.println("\nYou lost the move, you don't have that spell!!!\n");
                    break;
                } else {
                    if (hero.getCurrentPower() >= 4) {
                        hero.setCurrentPower(hero.getCurrentPower() - 4);
                    }
                    checkYourOpponent(hero, 2);
                    break;
                }

            case "3":
                if (hero.getHeroName() == mageFighter.getHeroName()) {
                    System.out.println("\nYou lost the move, you don't have that spell!!!\n");
                    break;
                } else {
                    if (hero.getCurrentPower() >= 4) {
                        hero.setCurrentPower(hero.getCurrentPower() - 4);
                    }
                    checkYourOpponent(hero, 3);
                    break;
                }
            case "4":
                if (hero.getHeroName() == warriorFighter.getHeroName()) {
                    System.out.println("\nYou lost the move, you don't have that spell!!!\n");
                    break;
                } else if (hero.getCurrentPower() >= 4) {
                    hero.setCurrentPower(hero.getCurrentPower() - 4);
                }
                checkYourOpponent(hero, 4);
                break;
            case "5":
                if (hero.getCurrentPower() >= 4) {
                    hero.setCurrentPower(hero.getCurrentPower() - 4);

                    if (hero.getCurrentHealth() < 25 && hero.getCurrentHealth() > 0) {
                        hero.setCurrentHealth(hero.getCurrentHealth() + 5);
                    }
                } else {
                    System.out.print("Sorry...");
                }
                break;
            default:
                checkYourOpponent(hero, 5);
                break;
        }
    }

    /**
     * This method allows the opponent to select a spell
     *
     * @param hero
     */
    public void chooseSpellHero2(Hero hero) {
        if (arena == 2) {
            hero.setCurrentHealth(hero.getCurrentHealth() - 4);
        } else if (arena == 3) {
            hero.setCurrentHealth(hero.getCurrentHealth() - 2);
        }
        if (mode == "Standard Battle Mode") {
            System.out.println("\u001B[32m" + "HERO 2:");
            int randNumber = ((int) (Math.random() * 10));
            switch (randNumber) {
                case 1:
                    theOpponentChecks(hero, 1);
                    break;
                case 2:
                    if (hero.getHeroName() == priestFighter.getHeroName()) {
                        break;
                    } else {
                        if (hero.getCurrentPower() >= 4) {
                            hero.setCurrentPower(hero.getCurrentPower() - 4);
                        }
                        theOpponentChecks(hero, 2);
                        break;
                    }
                case 3:
                    if (hero.getHeroName() == mageFighter.getHeroName()) {
                        break;
                    } else {
                        if (hero.getCurrentPower() >= 4) {
                            hero.setCurrentPower(hero.getCurrentPower() - 4);
                        }
                        theOpponentChecks(hero, 3);
                        break;
                    }
                case 4:
                    if (hero.getHeroName() == warriorFighter.getHeroName()) {
                        break;
                    } else {
                        if (hero.getCurrentPower() >= 4) {
                            hero.setCurrentPower(hero.getCurrentPower() - 4);
                        }
                        theOpponentChecks(hero, 4);
                        break;
                    }
                case 5:
                    if (hero.getCurrentPower() >= 4) {
                        hero.setCurrentPower(hero.getCurrentPower() - 4);
                        if (hero.getCurrentHealth() < 25 && hero.getCurrentHealth() > 0) {
                            hero.setCurrentHealth(hero.getCurrentHealth() + 5);
                        }
                    } else {
                        System.out.print("Sorry...");
                    }
                    break;
                default:
                    theOpponentChecks(hero, 1);
                    break;
            }
        } else {
            System.out.println("\u001B[32m" + "\nHERO 2:");
            System.out.println("\u001B[32m" + "\n1.Base attack\n2.MagicAttack\n3.PowerfulAttack\n4.QuickAttack\n5.Buff");
            String wantSpell = obj.nextLine();
            switch (wantSpell) {
                case "1":
                    theOpponentChecks(hero, 1);
                    break;
                case "2":
                    if (hero.getHeroName() == priestFighter.getHeroName()) {
                        System.out.println("\nYou lost the move, you don't have that spell!!!\n");
                        break;
                    } else {
                        if (hero.getCurrentPower() >= 4) {
                            hero.setCurrentPower(hero.getCurrentPower() - 4);
                        }
                        theOpponentChecks(hero, 2);
                        break;
                    }
                case "3":
                    if (hero.getHeroName() == mageFighter.getHeroName()) {
                        System.out.println("\nYou lost the move, you don't have that spell!!!\n");
                        break;
                    } else {
                        if (hero.getCurrentPower() >= 4) {
                            hero.setCurrentPower(hero.getCurrentPower() - 4);
                        }
                        theOpponentChecks(hero, 3);
                        break;
                    }
                case "4":
                    if (hero.getHeroName() == warriorFighter.getHeroName()) {
                        System.out.println("\nYou lost the move, you don't have that spell!!!\n");
                        break;
                    } else {
                        if (hero.getCurrentPower() >= 4) {
                            hero.setCurrentPower(hero.getCurrentPower() - 4);
                        }
                        theOpponentChecks(hero, 4);
                        break;
                    }
                case "5":
                    if (hero.getCurrentPower() >= 4) {
                        hero.setCurrentPower(hero.getCurrentPower() - 4);
                        if (hero.getCurrentHealth() < 25 && hero.getCurrentHealth() > 0) {
                            hero.setCurrentHealth(hero.getCurrentHealth() + 5);
                        }
                    } else {
                        System.out.print("Sorry...");
                    }
                    break;
                default:
                    theOpponentChecks(hero, 1);
                    break;
            }
        }
    }

    /**
     * This method calls the method for printing a combat log
     */
    public void showsCombatLog() {
        if (hero1 == mageFighter.getHeroName()) {
            attacks(mageFighter);
            if (hero2 == priestFighter.getHeroName()) {
                attacks(priestFighter);
                print(mageFighter, priestFighter);
            } else {
                attacks(warriorFighter);
                print(mageFighter, warriorFighter);
            }
        } else if (hero1 == priestFighter.getHeroName()) {
            attacks(priestFighter);
            if (hero2 == mageFighter.getHeroName()) {
                attacks(mageFighter);
                print(priestFighter, mageFighter);
            } else {
                attacks(warriorFighter);
                print(priestFighter, warriorFighter);
            }
        } else {
            attacks(warriorFighter);
            if (hero2 == mageFighter.getHeroName()) {
                attacks(mageFighter);
                print(warriorFighter, mageFighter);
            } else {
                attacks(priestFighter);
                print(warriorFighter, priestFighter);
            }
        }
    }

    /**
     * This method sets the player a certain level
     *
     * @param hero
     */
    public void level(Hero hero) {
        if (hero.getCurrentXP() > 10 && hero.getCurrentXP() <= 20) {
            hero.setCurrentLevel(2);
        } else if (hero.getCurrentXP() > 20 && hero.getCurrentXP() < 30) {
            hero.setCurrentLevel(3);
        } else if (hero.getCurrentXP() >= 30 && hero.getCurrentXP() < 40) {
            hero.setCurrentLevel(4);
        } else if (hero.getCurrentXP() >= 40 && hero.getCurrentXP() < 50) {
            hero.setCurrentLevel(5);
        }
    }

    /**
     * This method sets the spells to the player
     *
     * @param hero
     */
    public void attacks(Hero hero) {
        if (hero == mageFighter) {
            mageFighter.setSpell1(baseAttack);
            mageFighter.setSpell2(magicAttack);
            mageFighter.setSpell3(quickAttack);
        } else if (hero == priestFighter) {
            priestFighter.setSpell1(baseAttack);
            priestFighter.setSpell2(quickAttack);
            priestFighter.setSpell3(powerfulAttack);
        } else {
            warriorFighter.setSpell1(baseAttack);
            warriorFighter.setSpell2(powerfulAttack);
            warriorFighter.setSpell3(magicAttack);
        }
    }

    /**
     * This method checks and returns the winner
     *
     * @return the winner
     */
    public String result() {
        String result = "";
        if (hero1 == getMageFighter().getHeroName()) {
            if (hero2 == getPriestFighter().getHeroName()) {
                if (getMageFighter().getCurrentHealth() > getPriestFighter().getCurrentHealth()) {
                    result = "The winner is Mage";
                } else {
                    result = "The winner is Priest";
                }
            } else if (hero2 == getWarriorFighter().getHeroName()) {
                if (getMageFighter().getCurrentHealth() > getWarriorFighter().getCurrentHealth()) {
                    result = "The winner is Mage";
                } else {
                    result = "The winner is Warrior";
                }
            }
        } else if (hero1 == getPriestFighter().getHeroName()) {
            if (hero2 == getMageFighter().getHeroName()) {
                if (getPriestFighter().getCurrentHealth() > getMageFighter().getCurrentHealth()) {
                    result = "The winner is Priest";
                } else {
                    result = "The winner is Mage";
                }
            } else if (hero2 == getWarriorFighter().getHeroName()) {
                if (getPriestFighter().getCurrentHealth() > getWarriorFighter().getCurrentHealth()) {
                    result = "The winner is Priest";
                } else {
                    result = "The winner is Warrior";
                }
            }
        } else {
            if (hero2 == getMageFighter().getHeroName()) {
                if (getWarriorFighter().getCurrentHealth() > getMageFighter().getCurrentHealth()) {
                    result = "The winner is Warrior";
                } else {
                    result = "The winner is Mage";
                }
            } else if (hero2 == getPriestFighter().getHeroName()) {
                if (getWarriorFighter().getCurrentHealth() > getPriestFighter().getCurrentHealth()) {
                    result = "The winner is Warrior";
                } else {
                    result = "The winner is Priest";
                }
            }
        }
        return result;
    }

    public Hero getMageFighter() {
        return mageFighter;
    }

    public Hero getPriestFighter() {
        return priestFighter;
    }

    public Hero getWarriorFighter() {
        return warriorFighter;
    }
}

