import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    private ArrayList<Integer> days = new ArrayList<Integer>();
    private String name = "";
    private int startHour;
    private int endHour;

    public Course(){}
    public Course(String name,int start, int end, ArrayList<Integer> days){

        this.name = name;
        this.startHour = start;
        this.endHour = end;
        this.days = days;
    }
    public ArrayList<Integer> getDays(){
        return days;
    }
    public void set() {
        Scanner in = new Scanner(System.in);
        System.out.print("Name : ");
        name = in.nextLine();
        System.out.print("startHour : ");
        startHour = in.nextInt();
        System.out.print("endHour : ");
        endHour = in.nextInt();

        // add days
    }
    public void print(){
        System.out.println(name);
        System.out.println("Name: "  + name + "\nStartHour: " +  startHour + "\nEndHour: " + endHour  );
    }
}
