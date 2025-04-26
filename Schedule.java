import java.time.*;
import java.util.ArrayList;;

/**
 * A Schedule is an ArrayList of Course objects. A Schedule object is used to manage and store courses input by the user.
 * 
 * @author Will White, Brayden Xenos
 */
public class Schedule {

    private ArrayList<Course> schedule;

    /**
     * Constructs an empty Schedule with no Courses
     */
    public Schedule() {
        this.schedule = new ArrayList<Course>();
    }

    /**
     * Constructs a Schedule with an input Course
     */
    public Schedule(Course course) {
        this.schedule = new ArrayList<Course>();
        this.schedule.add(course);
    }

    /**
     * Adds a Course to the ArrayList
     */
    public void addCourse(Course course) {
        this.schedule.add(course);
    } 

    /**
     * Removes a Course to the ArrayList
     */
    public void removeCourse(Course course) {
        this.schedule.remove(course);
    } 
}
