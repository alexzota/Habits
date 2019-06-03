package habits.domain.repository;

import habits.domain.entity.Activity;
import habits.domain.entity.YearlyHabit;
import habits.tool.DBCONN;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class YearlyHabitRepositoryDB implements YearlyHabitRepository{
    private TreeSet<YearlyHabit> yearlyHabits = new TreeSet<>();

    public YearlyHabitRepositoryDB(){
        ResultSet rs = null;
        try {
            Connection conn = DBCONN.getConnection();
            Statement pst = conn.createStatement();
            rs = pst.executeQuery("Select * FROM YearlyHabits");

            while(rs.next()){
                YearlyHabit temp = new YearlyHabit();
                temp.setName(rs.getString("Name"));
                temp.setNote(rs.getString("Note"));
                temp.setStatus(rs.getBoolean("Status"));
                String datesRS = rs.getString("Dates");
                String[] dates = datesRS.split(",");
                temp.setDates(dates);
                yearlyHabits.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public TreeSet<YearlyHabit> getYearlyHabits(){
        return yearlyHabits;
    }
    public YearlyHabit getYearlyHabitById(int idd){
        Iterator<YearlyHabit> idx = yearlyHabits.iterator();
        while ( idx.hasNext()){
            YearlyHabit temp = idx.next();
            if (temp.getId() == idd ) return temp;
        }
        return null;
    }
}
