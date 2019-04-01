import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class YearlyHabit extends Activity {
    private ArrayList<CustomDate> dates = new ArrayList<CustomDate>();

    public YearlyHabit() {
    }

    public YearlyHabit(String name, String note, ArrayList<CustomDate> dates) {
        super(name, note);
        this.dates = dates;
    }

    public void reset() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //getTime() returns the current date in default time zone
        Date date = calendar.getTime();
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int monthOfYear = calendar.get(Calendar.MONTH);
        for (CustomDate idx : dates) {
            if (idx.getDay() == dayOfMonth && idx.getMonth() == monthOfYear) setStatus(false);
        }
    }

    public void addYearlyHabit(String name, String note, ArrayList<CustomDate> dates) {
        addActivity(name, note);
        this.dates = dates;
    }

    public void print() {
        System.out.print("\nActivity number " + this.getId() + "\nName: " + getName() + "\nStatus : " + getStatus() + "\nType: YearlyHabit\nNote:" + getNote() + "\n");
        System.out.print("Days Active : ");

        for (int i = 0; i < dates.size(); i++) {
            System.out.print(dates.get(i).getDay() + "-" + dates.get(i).getMonth()+", ");
        }
        System.out.println();
    }

}


