import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeeklyHabit extends Activity{
    private CustomDate date;
    private List<Integer> days = new ArrayList<Integer>();

    public WeeklyHabit(){}
    public WeeklyHabit(String name, String note, ArrayList<String> days){
        super(name,note);
        for( String idx : days) {
            Integer tempDate = dayStringToInt(idx);
            days.add(tempDate);
        }
    }

    public CustomDate getDate() {
        return date;
    }

    public void setDate(CustomDate date) {
        this.date = date;
    }
    public void reset(){
        String day = new SimpleDateFormat("EEEE").format(new Date());
        int intCurrentDay = dayStringToInt(day);
        if (intCurrentDay != date.getDay()) setStatus(false);
    }
    public void addWeeklyHabit(String name, String note, CustomDate date){
        addActivity(name,note);
        this.date = date;
    }
    public void print(){
        System.out.print("\nActivity number " + this.getId() +"\nName: " + getName() +"\nStatus : " + getStatus()+ "\nType: WeeklyHabit\nNote:" + getNote()+"\n");
    }


    public List<Integer> getDays() {
        return days;
    }

    public void setDays(List<Integer> days) {
        this.days = days;
    }
}
