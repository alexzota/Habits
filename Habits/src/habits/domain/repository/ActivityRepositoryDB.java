package habits.domain.repository;

import habits.domain.entity.*;
import habits.tool.DBCONN;

import java.sql.*;
import java.util.ArrayList;

public class ActivityRepositoryDB implements ActivityRepository{
    private ArrayList<Activity> activities = new ArrayList<>();


    public ActivityRepositoryDB(){
        ResultSet rs = null;
        try {
            Connection conn = DBCONN.getConnection();

            Statement pst = conn.createStatement();

            rs = pst.executeQuery("Select * FROM DailyHabits");

            while(rs.next()){
                DailyHabit temp = new DailyHabit();
                temp.setName(rs.getString("Name"));
                temp.setNote(rs.getString("Note"));
                temp.setStatus(rs.getBoolean("Status"));
                temp.setDay(rs.getInt("Day"));
                activities.add(temp);
            }
            rs = pst.executeQuery("Select * FROM WeeklyHabits");

            while(rs.next()){
                WeeklyHabit temp = new WeeklyHabit();
                temp.setName(rs.getString("Name"));
                temp.setNote(rs.getString("Note"));
                temp.setStatus(rs.getBoolean("Status"));
                String sDays = rs.getString("Days");
                String[] dayss = sDays.split(",");
                ArrayList<Integer> days =  new ArrayList<>();
                for(String a : dayss){
                    int b = Integer.parseInt(a);
                    days.add(b);
                }
                temp.setDays(days);
                activities.add(temp);
            }
            rs = pst.executeQuery("Select * FROM MonthlyHabits");

            while(rs.next()){
                MonthlyHabit temp = new MonthlyHabit();
                temp.setName(rs.getString("Name"));
                temp.setNote(rs.getString("Note"));
                temp.setStatus(rs.getBoolean("Status"));
                String sDays = rs.getString("Days");
                String[] dayss = sDays.split(",");
                ArrayList<Integer> days =  new ArrayList<>();
                for(String a : dayss){
                    int b = Integer.parseInt(a);
                    days.add(b);
                }
                temp.setDays(days);
                activities.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public ArrayList<Activity> getActivities(){
        return activities;
    }

    public Activity getActivityById(int id){
        Activity temp = new Activity();
        for (Activity a : activities){
            if (a.getId() == id) {
                temp = a;
                break;
            }
        }
        return temp;
    }

}
