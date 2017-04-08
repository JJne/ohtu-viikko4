/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

public class Course {
    private String name;
    private String term;
    
    private int week1;
    private int week2;
    private int week3;
    private int week4;
    private int week5;
    private int week6;
    
    @Override
    public String toString() {
        return name + ", " + term;
    }
    
    public int getWeek(int week) {
        switch (week) {
            case 1: return week1;
            case 2: return week2;
            case 3: return week3;
            case 4: return week4;
            case 5: return week5;
            case 6: return week6;
            default: return 0;
        }
    }
}
