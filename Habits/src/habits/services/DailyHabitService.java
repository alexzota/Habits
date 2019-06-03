package habits.services;
import habits.domain.entity.DailyHabit;
import habits.tool.DateConverterStoI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyHabitService {
    public static void print(DailyHabit object){
        System.out.print("\nActivity number " + object.getId() +"\nName: " + object.getName() +"\nStatus : " + object.getStatus()+ "\nType: DailyHabit\nNote:" + object.getNote()+"\n");
    }
    public void reset(DailyHabit object){
        String day = new SimpleDateFormat("EEEE").format(new Date());
        int intCurrentDay = DateConverterStoI.dayStringToInt(day);
        if (intCurrentDay != object.getDay()) object.setStatus(false);
    }
}
