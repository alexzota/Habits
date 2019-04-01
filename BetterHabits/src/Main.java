import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        PersonalAgenda pA = new PersonalAgenda();

        pA.addActivity(" Programare", "E ee");
        pA.addDailyhabit("Stat", "IAAAS", "Monday");

        ArrayList<String> days = new ArrayList<String>();
        days.add("monday");
        days.add("tuesday");
        days.add("friday");

        pA.addWeeklyhabit("Curatenie", "Pe jos si in inima", days);

        ArrayList<Integer> days1 = new ArrayList<Integer>();
        days1.add(2);
        days1.add(15);

        pA.addMonthlyHabit("PAO", "Nice", days1);

        ArrayList<CustomDate> dates = new ArrayList<CustomDate>();
        dates.add(new CustomDate(2,7));
        dates.add(new CustomDate(17,1));

        pA.addYearlyHabit("Achilles", "His backheel", dates);

        Exercise ex = new Exercise("Deadlift", 1, 5, 75);
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        exercises.add(ex);
        Workout wk = new Workout( 2, exercises );
        ArrayList<Workout> wkts = new ArrayList<Workout>();
        wkts.add(wk);
        pA.addGym("Strong in body and mind", "Work", days, wkts);

        pA.printActivities();
        
    }
}


