package rs.devcenter.battlearena;

import rs.devcenter.battlearena.fight.*;
import rs.devcenter.battlearena.fight.Fight;
import rs.devcenter.battlearena.sqliteConnection.Connect;
import static rs.devcenter.battlearena.sqliteConnection.Connect.createNewTable;

public class Main {

    public static void main(String args[]) {

        System.out.println("\u001B[35m" + "BATTLE ARENA -> WELCOME FIGHTERS!");
        Fight fight = new Fight();
        Connect connection = new Connect();
        Hero1 hero1 = new Hero1(fight);
        Hero2 hero2 = new Hero2(fight);
        String battleMode;
        if (fight.battleMode == 1) {
            battleMode = "Standard Battle Mode";
        } else {
            battleMode = "Epicenter Battle Mode";
        }
        Connect.connect();
        createNewTable();
        String arenaName = fight.arenaName();
        fight.showsCombatLog();
        hero2.start();
        hero1.start();

        try {
            Thread.sleep(120000);
            System.out.println("E N D");
            System.out.println("The one with more health WON!");
            hero1.stop();
            hero2.stop();
            connection.insertIntoTable(arenaName, fight.fighterName, fight.opponentName, battleMode, fight.result());
           connection.selectAll();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

