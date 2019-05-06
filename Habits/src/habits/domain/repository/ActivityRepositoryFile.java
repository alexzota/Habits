package habits.domain.repository;

import habits.domain.entity.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ActivityRepositoryFile implements ActivityRepository {
    private ArrayList<Activity> activities = new ArrayList<>();


    public ActivityRepositoryFile(String fisier1, String fisier2, String fisier3, String fisier4) throws FileNotFoundException {
        //System.out.println("Si intru si aici");
        FileInputStream dailyHabits = new FileInputStream(fisier1);
        Scanner scanner1 = new Scanner(dailyHabits);
        while(scanner1.hasNext()){
            String linie = scanner1.nextLine();
            String[] valori = linie.split(",");
            activities.add(new DailyHabit(valori[0], valori[1],valori[2]));
        }
        FileInputStream weeklyHabits = new FileInputStream(fisier2);
        Scanner scanner2 = new Scanner(weeklyHabits);
        while(scanner2.hasNext()){
            String linie = scanner2.nextLine();
            String[] valori = linie.split(",");
            ArrayList<String> days = new ArrayList<String>();
            String day = valori[2];
            days.add(day);
            activities.add(new WeeklyHabit(valori[0], valori[1],days));
        }
        FileInputStream MonthlyHabits = new FileInputStream(fisier3);
        Scanner scanner3 = new Scanner(MonthlyHabits);
        while(scanner3.hasNext()){
            String linie = scanner3.nextLine();
            String[] valori = linie.split(",");
            ArrayList<Integer> days = new ArrayList<Integer>();
            int day = Integer.parseInt(valori[2]);
            days.add(day);
            activities.add(new MonthlyHabit(valori[0], valori[1], days));
        }
        FileInputStream yearlyHabits = new FileInputStream(fisier3);
        Scanner scanner4 = new Scanner(yearlyHabits);
        while(scanner4.hasNext()){
            String linie = scanner4.nextLine();
            String[] valori = linie.split(",");
            CustomDate date = new CustomDate(Integer.parseInt(valori[2]), Integer.parseInt(valori[2]));
            ArrayList<CustomDate> dates = new ArrayList<CustomDate>();
            dates.add(date);
            activities.add(new YearlyHabit(valori[0], valori[1], dates));
        }
    }

    public ArrayList<Activity> getActivities(){
        return activities;
    }
    public Activity getActivityById(int id){
        Activity temp = new Activity();
        for(int i = 0; i < getActivities().size(); i++) if (getActivities().get(i).getId() == id) temp = getActivities().get(i);
        return temp;
    }
}
