import java.text.SimpleDateFormat;
import java.util.Date;
public class DailyHabit extends Activity {
    private CustomDate date;

    public DailyHabit(){}
    public DailyHabit(String name, String note, String day){
        super(name,note);
        CustomDate tempDate = new CustomDate(dayStringToInt(day));
        this.date = tempDate;
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
    public void addDailyHabit(String name, String note, CustomDate date){
        addActivity(name,note);
        this.date = date;
    }
    public void print(){
        System.out.print("\nActivity number " + this.getId() +"\nName: " + getName() +"\nStatus : " + getStatus()+ "\nType: DailyHabit\nNote:" + getNote()+"\n");
    }
}
