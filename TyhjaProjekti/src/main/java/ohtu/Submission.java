package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Submission {
    private String student_number;
    private String week;
    private int hours;
    
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;
    
    public String getWeek() {
        return week;
    }
    
    public int getHours() {
        return hours;
    }
    
    public String getStudent_number() {
        return student_number;
    }
   
    
    public void setWeek(String week) {
        this.week = week;
    }    
    
    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    
    public List<String> getCompletedTasks() {
        boolean[] tasks = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,
            a16,a17,a18,a19,a20,a21};
        
        List<String> completed = new ArrayList<>();
        
        for (int i=0; i < tasks.length; i += 1) {
            if (tasks[i]) {
                completed.add(""+(i+1));
            }
        }
        
        return completed;
    }

    @Override
    public String toString() {
        List<String> completed = getCompletedTasks();
        
        String str = "viikko " + week + ":";
        str += " tehtyjä tehtäviä yhteensä: " + completed.size() + ", ";
        str += "aikaa kului " + hours + " tuntia, ";
        str += "tehdyt tehtävät: " + String.join(" ", completed);
        
        return str;
    }
    
}