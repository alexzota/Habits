import java.util.ArrayList;
import java.util.Scanner;

public class SchoolDaySchedule {
    private int day;
    private ArrayList<Course> courses = new ArrayList<Course>();

    public SchoolDaySchedule(){}
    public SchoolDaySchedule(int day, ArrayList<Course> courses){
        this.day = day;
        this.courses = courses;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public void addCourses(){
        Scanner in = new Scanner(System.in);
        System.out.print("How many courses do you want to enter : ");
        int nrCourses = in.nextInt();
        for(int i = 0; i < nrCourses; i++) {
            Course temp = new Course();
            temp.set();
            courses.add(temp);
        }
    }

    public void print(){
        System.out.println("DAY " + day);
        for(Course idx : courses) idx.print();
        System.out.println();
    }
}
