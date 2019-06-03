package habits.domain.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyHabit extends Activity{
    //private CustomDate date;
    private int day;

    public DailyHabit(){}

    public DailyHabit(String name, String note, int day){
        super(name,note);
        this.day = day;
    }


    public void print(){
        System.out.print("\nActivity number " + this.getId() +"\nName: " + getName() +"\nStatus : " + getStatus()+ "\nType: DailyHabit\nNote:" + getNote()+"\n");
    }
    public void reset(){
        String day = new SimpleDateFormat("EEEE").format(new Date());
        int intCurrentDay = dayStringToInt(day);
        if (intCurrentDay != this.day) setStatus(false);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
