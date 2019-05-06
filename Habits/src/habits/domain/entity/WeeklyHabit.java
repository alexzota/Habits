package habits.domain.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WeeklyHabit extends Activity{
    private ArrayList<Integer> days = new ArrayList<Integer>();

    public WeeklyHabit(){}
    public WeeklyHabit(String name, String note, ArrayList<String> days){
        super(name,note);
        for( String idx : days) {
            Integer tempDate = dayStringToInt(idx);
            this.days.add(tempDate);
        }
    }

    public ArrayList<Integer> getDays(){
        return this.days;
    }

    public void print(){
        System.out.print("\nActivity number " + this.getId() +"\nName: " + getName() +"\nStatus : " + getStatus()+ "\nType: WeeklyHabit\nNote:" + getNote()+"\n");
        System.out.print("Days Active : ");

        for( int i = 0; i < days.size();i++) {
            System.out.print(days.get(i) + " ");
        }
        System.out.println();
    }
    public void reset(){
        String day = new SimpleDateFormat("EEEE").format(new Date());
        int intCurrentDay = dayStringToInt(day);

        for(int idx: days){
            if(intCurrentDay == idx) setStatus(false);
        }
    }
}
