package habits.services;
import habits.domain.repository.*;
import habits.domain.entity.*;
import habits.configuration.*;
import habits.tool.CsvWriter;
import habits.tool.DBCONN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonalAgendaService {
    private ActivityRepository activityRepository = RepositoryConfig.getInstance().getActivityRepository();
    private YearlyHabitRepository yearlyHabitRepository = RepositoryConfig.getInstance().getYearlyHabitRepository();
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

    public List<Activity> getActivities(){ return activityRepository.getActivities(); }


    public void addDailyHabit(String name, String note, boolean status,int day){
        try {
            Connection conn = DBCONN.getConnection();
            int idx = Activity.getIdx();
            String sqlQ = "INSERT INTO DailyHabits([Id],[Name],[Note],[Status],[Day]) VALUES (?,?,?,?,?) ";
            PreparedStatement sqlstatement = conn.prepareStatement(sqlQ);
            sqlstatement.setInt(1, idx);
            sqlstatement.setString(2, name);
            sqlstatement.setString(3, note);
            sqlstatement.setBoolean(4, status);
            sqlstatement.setInt(5, day);
            sqlstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateDailyHabit(int id,String name){
        try {
            Connection conn = DBCONN.getConnection();
            int idx = Activity.getIdx();
            String sqlQ = "UPDATE DailyHabits " +
                    "SET Name = ? WHERE id = ?";
            PreparedStatement sqlstatement = conn.prepareStatement(sqlQ);
            sqlstatement.setString(1, name);
            sqlstatement.setInt(2, id);
            sqlstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteDailyHabit(int id){
        try {
            Connection conn = DBCONN.getConnection();

            String sqlQ = "DELETE FROM DailyHabits " +
                          "WHERE id = ?";
            PreparedStatement sqlstatement = conn.prepareStatement(sqlQ);
            sqlstatement.setInt(1, id);
            sqlstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addWeeklyHabit(String name, String note, boolean status,String days){
        try {
            Connection conn = DBCONN.getConnection();
            int idx = Activity.getIdx();
            String sqlQ = "INSERT INTO WeeklyHabits([Id],[Name],[Note],[Status],[Days]) VALUES (?,?,?,?,?) ";
            PreparedStatement sqlstatement = conn.prepareStatement(sqlQ);
            sqlstatement.setInt(1, idx);
            sqlstatement.setString(2, name);
            sqlstatement.setString(3, note);
            sqlstatement.setBoolean(4, status);
            sqlstatement.setString(5, days);
            sqlstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateWeeklyHabit(int id,String days){
        try {
            Connection conn = DBCONN.getConnection();
            int idx = Activity.getIdx();
            String sqlQ = "UPDATE WeeklyHabits " +
                    "SET days = ? WHERE id = ?";
            PreparedStatement sqlstatement = conn.prepareStatement(sqlQ);
            sqlstatement.setString(1, days);
            sqlstatement.setInt(2, id);
            sqlstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteWeeklyHabit(int id){
        try {
            Connection conn = DBCONN.getConnection();

            String sqlQ = "DELETE FROM WeeklyHabits " +
                    "WHERE id = ?";
            PreparedStatement sqlstatement = conn.prepareStatement(sqlQ);
            sqlstatement.setInt(1, id);
            sqlstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMonthlyHabit(int id,String days){
        try {
            Connection conn = DBCONN.getConnection();
            int idx = Activity.getIdx();
            String sqlQ = "UPDATE MonthlyHabits " +
                    "SET days = ? WHERE id = ?";
            PreparedStatement sqlstatement = conn.prepareStatement(sqlQ);
            sqlstatement.setString(1, days);
            sqlstatement.setInt(2, id);
            sqlstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addMonthlyHabit(String name, String note, boolean status,String days){
        try {
            Connection conn = DBCONN.getConnection();
            int idx = Activity.getIdx();
            String sqlQ = "INSERT INTO MonthlyHabits([Id],[Name],[Note],[Status],[Days]) VALUES (?,?,?,?,?) ";
            PreparedStatement sqlstatement = conn.prepareStatement(sqlQ);
            sqlstatement.setInt(1, idx);
            sqlstatement.setString(2, name);
            sqlstatement.setString(3, note);
            sqlstatement.setBoolean(4, status);
            sqlstatement.setString(5, days);
            sqlstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteMonthlyHabit(int id){
        try {
            Connection conn = DBCONN.getConnection();

            String sqlQ = "DELETE FROM MonthlyHabits " +
                    "WHERE id = ?";
            PreparedStatement sqlstatement = conn.prepareStatement(sqlQ);
            sqlstatement.setInt(1, id);
            sqlstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addYearlyHabit(String name, String note, boolean status,String dates){
        try {
            Connection conn = DBCONN.getConnection();
            int idx = Activity.getIdx();
            String sqlQ = "INSERT INTO YearlyHabits([Id],[Name],[Note],[Status],[Dates]) VALUES (?,?,?,?,?) ";
            PreparedStatement sqlstatement = conn.prepareStatement(sqlQ);
            sqlstatement.setInt(1, idx);
            sqlstatement.setString(2, name);
            sqlstatement.setString(3, note);
            sqlstatement.setBoolean(4, status);
            sqlstatement.setString(5, dates);
            sqlstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateYearlyHabit(int id,String days){
        try {
            Connection conn = DBCONN.getConnection();
            int idx = Activity.getIdx();
            String sqlQ = "UPDATE YearlyHabits " +
                    "SET days = ? WHERE id = ?";
            PreparedStatement sqlstatement = conn.prepareStatement(sqlQ);
            sqlstatement.setString(1, days);
            sqlstatement.setInt(2, idx);
            sqlstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteYearlyHabit(int id){
        try {
            Connection conn = DBCONN.getConnection();

            String sqlQ = "DELETE FROM YearlyHabits " +
                    "WHERE id = ?";
            PreparedStatement sqlstatement = conn.prepareStatement(sqlQ);
            sqlstatement.setInt(1, id);
            sqlstatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
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
    public void printYearlyHabits(){
        CsvWriter write = new CsvWriter();
        write.addToFile("Printed Yearly Habits");

        Iterator<YearlyHabit> idx = yearlyHabitRepository.getYearlyHabits().iterator();
        while ( idx.hasNext()){
            YearlyHabit temp = idx.next();
            System.out.println(temp.toString());
        }
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
    public ArrayList<Activity> getWeeklyHabits(){
        ArrayList<Activity> WeeklyHabits = new ArrayList<Activity>();
        for( Activity idx : activityRepository.getActivities() ){
            if (idx instanceof WeeklyHabit) WeeklyHabits.add(idx);
        }
        return WeeklyHabits;
    }
    public ArrayList<Activity> getMonthlyHabits(){
        ArrayList<Activity> MonthlyHabits = new ArrayList<Activity>();
        for( Activity idx : activityRepository.getActivities() ){
            if (idx instanceof MonthlyHabit) MonthlyHabits.add(idx);
        }
        return MonthlyHabits;
    }
    public ArrayList<Activity> getYearlyHabits(){
        ArrayList<Activity> YearlyHabits = new ArrayList<Activity>();
        for( Activity idx : yearlyHabitRepository.getYearlyHabits() ){
            if (idx instanceof YearlyHabit) YearlyHabits.add(idx);
        }
        return YearlyHabits;
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
