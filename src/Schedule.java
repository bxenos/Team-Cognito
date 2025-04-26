import java.time.*;
import java.util.ArrayList;;

/**
 * A Schedule is an ArrayList of Course objects. A Schedule object is used to manage and store courses input by the user.
 * 
 * @author Will White, Brayden Xenos
 */
public class Schedule {

    private ArrayList<Course> schedule;
    private String username;
    private ScheduleDatabase db;

    /**
     * Constructs an empty Schedule with no Courses
     */
    public Schedule(String username) {
        this.username = username;
        this.schedule = new ArrayList<Course>();
        this.db = new ScheduleDatabase("ScheduleDB_" + username);
    }

    /**
     * Adds a Course to the ArrayList
     */
    public void addCourse(Course course) {
        this.schedule.add(course);
        this.db.createCourse("ScheduleDB_" + username, course.getCourseName(), course.getCourseStartTime(), course.getCourseEndTime(), course.getCourseLocation());
    } 

    /**
     * Removes a Course to the ArrayList
     */
    public void removeCourse(Course course) {
        this.schedule.remove(course);
    } 
}
