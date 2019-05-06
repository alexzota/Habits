package habits.services;
import habits.domain.repository.*;
import habits.domain.entity.*;
import habits.configuration.*;
import habits.tool.CsvWriter;

import java.util.ArrayList;

public class PersonalAgendaService {
    private ActivityRepository activityRepository = RepositoryConfig.getInstance().getActivityRepository();
//
//    public void printActivity(Activity object){
//        System.out.print("\nActivity number " + object.getId() + "\nName: " + object.getName() +"\nStatus : " + object.getStatus() + "\nNote:" + object.getNote()+"\n");
//    }
//    public void printDailyHabit(DailyHabit object){
//        System.out.print("\nActivity number " + object.getId() +"\nName: " + object.getName() +"\nStatus : " + object.getStatus()+ "\nType: DailyHabit\nNote:" + object.getNote()+"\n");
//    }
//
//    public void printWeeklyHabit(WeeklyHabit object){
//        System.out.print("\nActivity number " + object.getId() +"\nName: " + object.getName() +"\nStatus : " + object.getStatus()+ "\nType: WeeklyHabit\nNote:" + object.getNote()+"\n");
//        System.out.print("Days Active : ");
//
//        for( int i = 0; i < object.getDays().size();i++) {
//            System.out.print(object.getDays().get(i) + " ");
//        }
//        System.out.println();
//    }
//
//    public void printMonthlyHabit(MonthlyHabit object) {
//        System.out.print("\nActivity number " + object.getId() + "\nName: " + object.getName() + "\nStatus : " + object.getStatus() + "\nType: MonthlyHabit\nNote:" + object.getNote() + "\n");
//        System.out.print("Days Active : ");
//
//        for (int i = 0; i < object.getDays().size(); i++) {
//            System.out.print(object.getDays().get(i) + " ");
//        }
//    }
//    public void printYearlyHabit(YearlyHabit object) {
//        System.out.print("\nActivity number " + object.getId() + "\nName: " + object.getName() + "\nStatus : " + object.getStatus() + "\nType: YearlyHabit\nNote:" + object.getNote() + "\n");
//        System.out.print("Days Active : ");
//
//        for (int i = 0; i < object.getDates().size(); i++) {
//            System.out.print(object.getDates().get(i).getDay() + "-" + object.getDates().get(i).getMonth()+", ");
//        }
//        System.out.println();
//    }

    public void printActivities(){
        CsvWriter write = new CsvWriter();
        write.addToFile("Print Activities");

        ArrayList<Activity> temps = activityRepository.getActivities();
        for( Activity idx: temps) idx.print();
    }
    public void resetActivities(){
        CsvWriter write = new CsvWriter();
        write.addToFile("Reseted Activities");

        ArrayList<Activity> temps = activityRepository.getActivities();
        for( Activity idx: temps) idx.reset();
    }

    public Activity getActivityById(int id){
        Activity temp = new Activity();
        for(int i = 0; i < activityRepository.getActivities().size(); i++) if (activityRepository.getActivities().get(i).getId() == id) temp = activityRepository.getActivities().get(i);
        return temp;
    }

    public void printActivityById(int id){
        CsvWriter write = new CsvWriter();
        write.addToFile("Printed Activity by ID");
        getActivityById(id).print();
    }
    public Activity getActivityByName(String name){
        Activity temp = new Activity();
        for(int i = 0; i < activityRepository.getActivities().size(); i++) if (activityRepository.getActivities().get(i).getName() == name) temp = activityRepository.getActivities().get(i);
        return temp;
    }
    public void printActivityByName(String name){
        CsvWriter write = new CsvWriter();
        write.addToFile("Printed Activity by NAME");
        getActivityByName(name).print();
    }

    public ArrayList<Activity> getDailyHabits(){
        ArrayList<Activity> dailyHabits = new ArrayList<Activity>();
        for( Activity idx : activityRepository.getActivities() ){
            if (idx instanceof DailyHabit) dailyHabits.add(idx);
        }
        return dailyHabits;
    }
    public void printDailyHabits(){
        CsvWriter write = new CsvWriter();
        write.addToFile("Printed the Daily Habits");
        for (Activity idx : getDailyHabits()) idx.print();
    }



    public ArrayList<Activity> getCompletedActivities(){
        ArrayList<Activity> completedActivities = new ArrayList<Activity>();
        for( Activity idx : activityRepository.getActivities() ){
            if (idx.getStatus() == true) completedActivities.add(idx);
        }
        return completedActivities;
    }

    public void printCompletedActivities(){
        CsvWriter write = new CsvWriter();
        write.addToFile("Printed the compelted activities");
        for ( Activity idx : getCompletedActivities()){
            idx.print();
        }
    }
    public ArrayList<Activity> getUncompletedActivities(){
        ArrayList<Activity> completedActivities = new ArrayList<Activity>();
        for( Activity idx : activityRepository.getActivities() ){
            if (idx.getStatus() == false) completedActivities.add(idx);
        }
        return completedActivities;
    }

    public void printUncompletedActivities(){
        CsvWriter write = new CsvWriter();
        write.addToFile("Printed the uncompleted activities");
        for ( Activity idx : getUncompletedActivities()){
            idx.print();
        }
    }
}
