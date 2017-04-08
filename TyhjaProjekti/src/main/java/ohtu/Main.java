package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "";
        
        if (args.length > 0) {
            studentNr = args[0];
        }
        
        if (studentNr.isEmpty()) {
            System.out.println("Opiskelijanumero täytyy antaa.");
        }

        String submissionsUrl = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";
        String submissionsBodyText = Request.Get(submissionsUrl).execute().returnContent().asString();
        
        String courseUrl = "https://ohtustats2017.herokuapp.com/courses/1.json";
        String courseBodyText = Request.Get(courseUrl).execute().returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(submissionsBodyText, Submission[].class);
        Course course = mapper.fromJson(courseBodyText, Course.class);
        
        int hoursTotal = 0;
        int tasksTotal = 0;
        
        System.out.println(course + "\n");
        System.out.println("opiskelijanumero: " + studentNr + "\n");
        for (Submission submission : subs) {
            submission.setCourse(course);
            
            System.out.println(submission);
            
            hoursTotal += submission.getHours();
            tasksTotal += submission.getCompletedTasks().size();
        }
        System.out.println("\nyhteensä: " + tasksTotal + " tehtävää " + hoursTotal + " tuntia\n");

    }
}