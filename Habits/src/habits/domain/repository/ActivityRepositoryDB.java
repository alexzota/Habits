package habits.domain.repository;

import habits.domain.entity.Activity;
import java.sql.*;
import java.util.ArrayList;

public class ActivityRepositoryDB implements ActivityRepository{
    private ArrayList<Activity> activities = new ArrayList<>();


    public ActivityRepositoryDB(){
        ResultSet rs = null;
        try {
            String url = "jdbc:sqlserver://DESKTOP-5MDD5TR\\ZOTASQL:1433;databaseName=HabitsDatabase;";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url,"sa","123456");
            Statement pst = conn.createStatement();
            rs = pst.executeQuery("Select * FROM ACTIVITIES");

            while(rs.next()){
                Activity temp = new Activity();
                temp.setId(rs.getInt("Id"));
                temp.setName(rs.getString("Name"));
                temp.setNote(rs.getString("Note"));
                temp.setStatus(rs.getBoolean("Status"));

                activities.add(temp);
            }

        } catch (SQLException | ClassNotFoundException e) {
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
