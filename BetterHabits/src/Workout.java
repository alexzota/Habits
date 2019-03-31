import java.util.ArrayList;

public class Workout {
    private int day;
    private ArrayList<Exercise> exercises = new ArrayList<Exercise>();

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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
    }
}
