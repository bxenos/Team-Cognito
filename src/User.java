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
        System.out.println("\nCourse " + courseName + " added to table Courses, in database ScheduleDB_" + username);

        Schedule mySchedule = new Schedule(username);
        User myUser = new User(username, "BSU", mySchedule);

        Course course = new Course(courseName, startTime, endTime, location);
        mySchedule.addCourse(course);

        System.out.print("\nManage Database: [<add_course>] [<delete_course>] [<q>]\n");
        String input = scnr.nextLine();
        while (!input.equals("q")) {

            if (input.equals("add_course")) {
                System.out.print("\nEnter course name: ");
                courseName = scnr.nextLine();
                System.out.print("\nEnter start time: ");
                startTime = scnr.nextLine();
                System.out.print("\nEnter end time: ");
                endTime = scnr.nextLine();
                System.out.print("\nEnter location: ");
                location = scnr.nextLine();
                System.out.print("\nCourse " + courseName + " added to table Courses, in database ScheduleDB_" + username);

                course = new Course(courseName, startTime, endTime, location);
                mySchedule.addCourse(course);

            }else if (input.equals("delete_course")) {
                System.out.print("\nEnter the name of course to be deleted: ");
                courseName = scnr.nextLine();

                course = new Course(courseName, "", "", "");
                mySchedule.removeCourse(course);
                System.out.print("\nCourse " + courseName + " deleted from table Courses, in database ScheduleDB_" + username);
            } else {
                System.out.print("Invalid option: [<add_course>] [<delete_course>] [<q>]\n");
            }

            System.out.print("\nManage Database: [<add_course>] [<delete_course>] [<q>]\n");
            input = scnr.nextLine();
        }

        scnr.close();
    }
 }