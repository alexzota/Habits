import java.util.ArrayList;

public class PersonalAgenda {
    public ArrayList<Activity> activities = new ArrayList<Activity>();


    public PersonalAgenda(){}

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(String name, String note){
        Activity temp = new Activity(name, note);
        activities.add(temp);
    }
    public void addDailyhabit(String name, String note,String day){
        Activity temp = new DailyHabit(name, note, day);
        activities.add(temp);
    }
    public void addWeeklyhabit(String name, String note,ArrayList<String> days){
        Activity temp = new WeeklyHabit(name, note, days);
        activities.add(temp);
    }
    public void addMonthlyHabit(String name, String note,ArrayList<Integer> days){
        Activity temp = new MonthlyHabit(name, note, days);
        activities.add(temp);
    }
    public void addYearlyHabit(String name, String note,ArrayList<CustomDate> dates){
        Activity temp = new YearlyHabit(name, note, dates);
        activities.add(temp);
    }
    public void addGym(String name, String note,ArrayList<String> days){
        Activity temp = new Gym(name, note, days);
        activities.add(temp);
    }
    public void addGym(String name, String note,ArrayList<String> days, ArrayList<Workout> wkts){
        Activity temp = new Gym(name, note, days, wkts);
        activities.add(temp);
    }
    public void addJob(String name, String note, ArrayList<String> days, ArrayList<Project> projects){
        Activity temp = new Job(name, note, days, projects);
        activities.add(temp);
    }
    public void addSchool(String name, String note, ArrayList<String> days, ArrayList<Project> projects, ArrayList<SchoolDaySchedule> daysSchedule){
        Activity temp = new School(name, note, days, projects, daysSchedule);
        activities.add(temp);
    }

    public void printActivities(){
        ArrayList<Activity> temps = this.getActivities();
        for( Activity idx: temps) idx.print();
    }

}


