import java.time.LocalTime;

/**
 * A Course object stores all information about a class. A Course object should be used in a collection to form a Schedule.
 * 
 * @author Will White
 */
public class Course {

    private String courseStartTime;
    private String courseEndTime;
    private String courseName;
    private String courseLocation;

    /**
     * Constructs a new Course object
     */
    public Course(String courseStartTime, String courseEndTime, String courseName, String courseLocation) {

        this.courseStartTime = courseStartTime;
        this.courseEndTime = courseEndTime;
        this.courseName = courseName;
        this.courseLocation = courseLocation;
    }

    /**
     * Gets the start time of the Course
     * 
     * @return courseStartTime
     */
    public String getCourseStartTime() {
        return this.courseStartTime;
    }

    /**
     * Gets the end time of the Course
     * 
     * @return courseEndTime
     */
    public String getCourseEndTime() {
        return this.courseEndTime;
    }

    /**
     * Gets the name of the Course
     * 
     * @return courseName
     */
    public String getCourseName() {
        return this.courseName;
    }

    /**
     * Gets the location of the Course
     * 
     * @return courseLocationTime
     */
    public String getCourseLocation() {
        return this.courseLocation;
    }

    /**
     * Sets the start time of the Course
     * 
     * @param courseStartTime
     */
    public void setCourseStartTime(String courseStartTime) {
        this.courseStartTime = courseStartTime;
    }

    /**
     * Sets the end time of the Course
     * 
     * @param courseEndTime
     */
    public void setCourseEndTime(String courseEndTime) {
        this.courseEndTime = courseEndTime;
    }

    /**
     * Sets the name of the Course
     * 
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Sets the location of the Course
     * 
     * @param courseLocation
     */
    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }
}