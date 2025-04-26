import static spark.Spark.*;

public class JavaServer {
    public static void main(String[] args) {
        post("/addCourse", (req, res) -> {
            String courseName = req.queryParams("courseName");
            String startTime = req.queryParams("startTime");
            String endTime = req.queryParams("endTime");
            String location = req.queryParams("location");

            // Use the data to create a Course object
            Course course = new Course(startTime, endTime, courseName, location);
            Schedule schedule = new Schedule("username"); // Replace with actual username
            schedule.addCourse(course);

            return "Course added successfully!";
        });
    }
}