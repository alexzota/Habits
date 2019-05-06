package habits.domain.repository;

import habits.domain.entity.Activity;

import java.util.ArrayList;

public interface ActivityRepository {
    public ArrayList<Activity> getActivities();

    public Activity getActivityById(int id);
}
