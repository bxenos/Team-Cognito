import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Database for a Schedule
 * 
 * @author
 */
public class Database {
    
    private String sqliteFilename;

    /**
     * Construct new Database
     * 
     * @param sqliteFilename
     */
    public Database(String sqliteFilename) {
        this.sqliteFilename = sqliteFilename;
    }

    /**
     * Creates a connection to the sqlite database
     * 
     * @return connection to database
     */
    public void getDatabaseConnection(String dbName, String tableName) throws SQLException {
        
        String connectionURL = "jdbc:sqlite:" + dbName + ".db";
        System.out.println("URL = " + connectionURL);

        try (Connection connection = DriverManager.getConnection(connectionURL)){
            try (Statement myState = connection.createStatement()){
                myState.execute("drop table if it exists table");
                myState.execute("create table MYNAME (name string, number integer)");
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement("insert into MYNAME (name, number) values (?, ?)")){
                preparedStatement.setString(1, "TEST");
                preparedStatement.setInt(2, 777);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Database db = new Database("Test-Table");
        try {
            db.getDatabaseConnection("Test", "Test_Table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
