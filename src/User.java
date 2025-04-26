import java.sql.SQLException;
import java.util.Scanner;

public class User {
    //instance variables
    private String username;
    private String school;
    private Schedule schedule;
    
    /**
     * constructor to make user
     */
    public User(String username, String school, Schedule schedule) {
        this.username = username;
        this.school = school;
        this.schedule = schedule;
    }

    /**
     * getter for user's name
     * 
     * @returns User's name
     */
    public String getName() {
        return username;
    }

    /**
     * getter for user's school
     * 
     * @returns User's school
     */
    public String getSchool() {
        return school;
    }

    /**
     * Adds a new class to the users schedule
     */
    public void addNewCourse() {
        //DO SOMETHING
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("\nEnter your name: ");
        String username = scnr.nextLine();
        System.out.print("\nEnter course name: ");
        String courseName = scnr.nextLine();
        System.out.print("\nEnter start time: ");
        String startTime = scnr.nextLine();
        System.out.print("\nEnter end time: ");
        String endTime = scnr.nextLine();
        System.out.print("\nEnter location: ");
        String location = scnr.nextLine();

        Schedule mySchedule = new Schedule(username);
        User myUser = new User(username, "BSU", mySchedule);

        Course course1 = new Course(courseName, startTime, endTime, location);
        mySchedule.addCourse(course1);
        // ScheduleDatabase db = new ScheduleDatabase("ScheduleDB");
        // try {
        //     db.createDatabase("Courses");
        // } catch (SQLException e) {
        //     System.out.println(e);
        // }
        // db.createCourse("Courses", "CS321", "9:00am", "10:15am", "CCP231");
    }
 }