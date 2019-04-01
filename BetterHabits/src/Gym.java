import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Gym extends WeeklyHabit {
    private ArrayList<Workout> workouts = new ArrayList<Workout>();

    public Gym(){}
    public Gym(String name, String note, ArrayList<String> days){
        super(name,note, days);
        }
    public Gym(String name, String note, ArrayList<String> days, ArrayList<Workout> wkts){
        super(name,note, days);
        setWorkouts(wkts);
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
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int currentDay = calendar.get(calendar.DAY_OF_WEEK);
        for(Workout idx : workouts){
            if (idx.getDay() == currentDay){
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
