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
public class ScheduleDatabase {
    
    private String sqliteFilename;
    private String connectionURL;
    //private Connection connection;

    /**
     * Construct new Database
     * 
     * @param sqliteFilename
     */
    public ScheduleDatabase(String sqliteFilename) {
        this.sqliteFilename = sqliteFilename;
        this.connectionURL = "jdbc:sqlite:" + sqliteFilename + ".db";
        try {
            createDatabase("Courses");
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    /**
     * Creates a connection to the sqlite database
     * 
     * @return connection to database
     */
    public void createDatabase(String tableName) throws SQLException {
        
        System.out.println("URL = " + connectionURL);

        try {
            Connection connection = DriverManager.getConnection(connectionURL);
            Statement myState = connection.createStatement();
            myState.execute("drop table if exists " + sqliteFilename);
            myState.execute("create table if not exists " + tableName + " (courseName string, startTime string, endTime string, location string)");
            //myState.executeUpdate(connectionURL);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createCourse(String tableName, String courseName, String startTime, String endTime, String location) {

        try{
            Connection connection = DriverManager.getConnection(connectionURL);
            PreparedStatement preparedStatement = connection.prepareStatement("insert or ignore into " + tableName + " (courseName, startTime, endTime, location) values (?, ?, ?, ?)");
            preparedStatement.setString(1, courseName);
            preparedStatement.setString(2, startTime);
            preparedStatement.setString(3, endTime);
            preparedStatement.setString(4, location);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        //ScheduleDatabase db = new ScheduleDatabase("ScheduleDB");
        // try {
        //     db.createDatabase("Courses");
        // } catch (SQLException e) {
        //     System.out.println(e);
        // }
        //db.createCourse("Courses", "CS321", "9:00am", "10:15am", "CCP231");
    }

}
