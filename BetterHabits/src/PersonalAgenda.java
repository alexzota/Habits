import java.lang.reflect.Array;
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

    public Activity getActivityById(int id){
        Activity temp = new Activity();
        for(int i = 0; i < getActivities().size(); i++) if (getActivities().get(i).getId() == id) temp = getActivities().get(i);
        return temp;
    }
    public void printActivityById(int id){
        getActivityById(id).print();
    }
    public Activity getActivityByName(String name){
        Activity temp = new Activity();
        for(int i = 0; i < getActivities().size(); i++) if (getActivities().get(i).getName() == name) temp = getActivities().get(i);
        return temp;
    }
    public void printActivityById(String name){
        getActivityByName(name).print();
    }

    public ArrayList<Activity> getDailyHabits(){
        ArrayList<Activity> dailyHabits = new ArrayList<Activity>();
        for( Activity idx : getActivities() ){
            if (idx instanceof DailyHabit) dailyHabits.add(idx);
        }
        return dailyHabits;
    }
    public void printDailyHabits(){
        for (Activity idx : getDailyHabits()) idx.print();
    }



    public ArrayList<Activity> getCompletedActivities(){
        ArrayList<Activity> completedActivities = new ArrayList<Activity>();
        for( Activity idx : getActivities() ){
            if (idx.getStatus() == true) completedActivities.add(idx);
        }
        return completedActivities;
    }

    public void printCompletedActivities(){
        for ( Activity idx : getCompletedActivities()){
            idx.print();
        }
    }
    public ArrayList<Activity> getUncompletedActivities(){
        ArrayList<Activity> completedActivities = new ArrayList<Activity>();
        for( Activity idx : getActivities() ){
            if (idx.getStatus() == false) completedActivities.add(idx);
        }
        return completedActivities;
    }

    public void printUncompletedActivities(){
        for ( Activity idx : getUncompletedActivities()){
            idx.print();
        }
    }
}
