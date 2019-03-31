import java.util.ArrayList;
import java.util.Scanner;

public class Gym extends WeeklyHabit {
    private ArrayList<Workout> workouts = new ArrayList<Workout>();

    public Gym(){}
    public Gym(String name, String note, ArrayList<String> days){
        super(name,note, days);
        }
    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(ArrayList<Workout> workouts) {
        this.workouts = workouts;
    }
    public void addWorkout(){
        Workout temp = new Workout();
        System.out.print("Day of workout : ");
        Scanner in = new Scanner(System.in);
        int dayOfWorkout = in.nextInt();
        temp.setDay(dayOfWorkout);
        temp.addExercises();
    }

    public Workout getTodaysWorkout(){
        Workout temp = new Workout();
        for(Workout idx : workouts){
            if (idx.getDay() == getDate().getDay()){
                temp = idx;
            }
        }
        return temp;
    }
    public void print(){

        System.out.print("\nActivity number " + this.getId() +"\nName: " + getName() +"\nStatus : " + getStatus()+ "\nType: Gym\nNote:" + getNote()+"\n");
        System.out.print("Days Active : ");

        for( int idx : this.getDays()) {
            System.out.print(idx + " ");
        }
        System.out.println();

        getTodaysWorkout().print();
    }
}


