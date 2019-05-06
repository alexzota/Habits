package habits.domain.repository;

import habits.domain.entity.*;

import java.util.ArrayList;

public class ActivityRepositoryStatic implements ActivityRepository{
    private ArrayList<Activity> activities = new ArrayList<>();

    public ActivityRepositoryStatic(){
        activities.add(new Activity(" Programare", "E ee"));
        activities.add(new DailyHabit("Invatat", "la PAO", "Monday"));
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
