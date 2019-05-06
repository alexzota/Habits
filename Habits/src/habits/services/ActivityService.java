package habits.services;

import habits.domain.entity.Activity;
import habits.domain.entity.DailyHabit;
import habits.tool.DateConverterStoI;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityService {
    public void print(Activity object){
        System.out.print("\nActivity number " + object.getId() + "\nName: " + object.getName() +"\nStatus : " + object.getStatus() + "\nNote:" + object.getNote()+"\n");
    }
}
