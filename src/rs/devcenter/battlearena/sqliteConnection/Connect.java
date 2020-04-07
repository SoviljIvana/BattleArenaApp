package rs.devcenter.battlearena.sqliteConnection;

import java.sql.*;

/**
 * This class is used to interact with the database
 *
 * @author Sovilj Ivana
 * @since
 */
public class Connect {

    /**
     * This method is used to create database (CombatLog)
     *
     * @return
     */
    public static Connection connect() {

        String url = "jdbc:sqlite:C:\\Users\\User\\Desktop\\BattleArena\\db\\combatLog.db";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    /**
     * This method is used to create new table 'battles'
     */
    public static void createNewTable() {

        String url = "jdbc:sqlite:C:\\Users\\User\\Desktop\\BattleArena\\db\\combatLog.db";

        String sql = "CREATE TABLE IF NOT EXISTS battles" +
                "(id integer PRIMARY KEY AUTOINCREMENT," +
                "arenaName text NOT NULL, " +
                "hero1 text NOT NULL," +
                "hero2 text NOT NULL," +
                "battleMode text NOT NULL ," +
                "result text NOT NULL)";

        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is used to insert data into table 'battles'
     *
     * @param arenaName -arena where is battle(killerArena or stoneArena or iceArena or grassArena or sandArena or muddyArena or specialArena or basicArena)
     * @param hero1     -first competitor (warrior, priest or mage)
     * @param hero2     -second competitor (warrior, priest or mage)
     * @param result    -the result at the end of the fight
     */
    public void insertIntoTable(String arenaName, String hero1, String hero2, String battleMode, String result) {

        String sql = "INSERT INTO battles" +
                "( arenaName, hero1, hero2, battleMode, result) VALUES (?,?,?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pStatement = conn.prepareStatement(sql)) {
            pStatement.setString(1, arenaName);
            pStatement.setString(2, hero1);
            pStatement.setString(3, hero2);
            pStatement.setString(4, battleMode);
            pStatement.setString(5, result);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is used to print combatLog
     */
    public void selectAll() {
        String sql = "SELECT id,arenaName,hero1,hero2,battleMode, result FROM battles";

        try (Connection connection = this.connect();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                System.out.println(rs.getInt("id") + "\t\t" + "\u001B[32m" +
                        rs.getString("arenaName") + "\t\t" + "\u001B[30m" +
                        rs.getString("hero1") + "\t\t" + "\u001B[34m" +
                        rs.getString("hero2") + "\t\t" + "\u001B[31m" +
                        rs.getString("battleMode") + "\t\t" + "\u001B[30m" +
                        rs.getString("result"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is used to modify the table data
     */
    public void update(int id, String arenaName, String hero1, String hero2, String battleMode, String result) {
        {
            String sql = "UPDATE battles SET  arenaName  = ?, hero1  = ?, hero2  = ?, battleMode  = ? , result = ? WHERE id = ?";
            try (Connection connection = this.connect();
                 PreparedStatement pStatement = connection.prepareStatement(sql)) {
                pStatement.setString(1, arenaName);
                pStatement.setString(2, hero1);
                pStatement.setString(3, hero2);
                pStatement.setString(4, battleMode);
                pStatement.setString(5, result);
                pStatement.setInt(6, id);
                pStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * This method deletes the row in the table 'battles' via id
     *
     * @param id is primary key autoincrement in table 'battles'
     */
    public void delete(int id) {

        String sql = "DELETE FROM battles WHERE id = ?";
        try (Connection connection = this.connect();
             PreparedStatement pStatement = connection.prepareStatement(sql)) {
            pStatement.setInt(1, id);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

