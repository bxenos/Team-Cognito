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

    public void deleteCourse(String tableName, String courseName) {

        try{
            Connection connection = DriverManager.getConnection(connectionURL);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from " + tableName + " where courseName = ?");

            preparedStatement.setString(1, courseName);
            int rows = preparedStatement.executeUpdate();
            //TODO no course found

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
