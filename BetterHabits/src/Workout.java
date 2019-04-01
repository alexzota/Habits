import java.util.ArrayList;
import java.util.Scanner;

public class Workout {
    private int day;
    private ArrayList<Exercise> exercises = new ArrayList<Exercise>();

    public Workout(){}
    public Workout(int day, ArrayList<Exercise> exercises){
        this.day = day;
        this.exercises = exercises;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public void addExercises(){
        Scanner in = new Scanner(System.in);
        System.out.print("How many exercises do you want to enter : ");
        int nrExercises = in.nextInt();
        for(int i = 0; i < nrExercises; i++) {
            Exercise temp = new Exercise();
            temp.set();
            exercises.add(temp);
        }
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }
    public void print(){
        System.out.println("DAY " + day);
        for(Exercise idx : exercises) idx.print();
        System.out.println();
    }
}
