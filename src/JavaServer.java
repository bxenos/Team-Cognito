import com.google.gson.Gson;
import static spark.Spark.*;

public class JavaServer {
    public static void main(String[] args) {
        port(5000);

        post("/addCourse", (req, res) -> {
            // Parse JSON data
            Gson gson = new Gson();
            CourseData courseData = gson.fromJson(req.body(), CourseData.class);

            // Log the received data
            System.out.println("Received course details:");
            System.out.println("Course Name: " + courseData.courseName);
            System.out.println("Start Time: " + courseData.startTime);
            System.out.println("End Time: " + courseData.endTime);
            System.out.println("Location: " + courseData.location);

            // Process the data and save to database 

            // Send a response back to the Node.js server
            return "Course added successfully!";
        });
    }

    // Define a class to map the JSON data
    static class CourseData {
        String courseName;
        String startTime;
        String endTime;
        String location;
    }
}