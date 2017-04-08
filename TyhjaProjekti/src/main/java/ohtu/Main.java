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

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        int hoursTotal = 0;
        int tasksTotal = 0;
        
        System.out.println("opiskelijanumero: " + studentNr + "\n");
        for (Submission submission : subs) {
            System.out.println(submission);
            
            hoursTotal += submission.getHours();
            tasksTotal += submission.getCompletedTasks().size();
        }
        System.out.println("\nyhteensä: " + tasksTotal + " tehtävää " + hoursTotal + " tuntia\n");

    }
}