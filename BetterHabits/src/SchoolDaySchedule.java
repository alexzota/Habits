import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class School  extends WeeklyHabit{
    private ArrayList<Project> projects = new ArrayList<Project>();
    private ArrayList<SchoolDaySchedule> daysSchedule = new ArrayList<SchoolDaySchedule>();


    public School(){}
    public School(String name, String note, ArrayList<String> days, ArrayList<Project> projects){
        super(name,note,days);
        this.projects = projects;
    }

    public void addProject( Project pj ){
        projects.add(pj);
    }
    public void addSchoolDaySchedule(SchoolDaySchedule sds)
    {
        daysSchedule.add(sds);
    }

    public SchoolDaySchedule getCurrentDaySchedule(){
        SchoolDaySchedule temp = new SchoolDaySchedule();
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int currentDay = calendar.get(calendar.DAY_OF_WEEK);
        for(SchoolDaySchedule idx : daysSchedule){
            if (idx.getDay() == currentDay){
                temp = idx;
            }
        }
        return temp;
    }
    public void print(){
        System.out.print("\nActivity number " + this.getId() +"\nName: " + getName() +"\nStatus : " + getStatus()+ "\nType: School\nNote:" + getNote()+"\n");
        System.out.print("Days Active : ");

        for( int idx : this.getDays()) {
            System.out.print(idx + " ");
        }
        System.out.println();

        getCurrentDaySchedule().print();
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<SchoolDaySchedule> getDaysSchedule() {
        return daysSchedule;
    }

    public void setDaysSchedule(ArrayList<SchoolDaySchedule> daysSchedule) {
        this.daysSchedule = daysSchedule;
    }
}
