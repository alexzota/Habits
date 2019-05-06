package habits.domain.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MonthlyHabit extends Activity {
    private CustomDate date = new CustomDate();
    private ArrayList<Integer> days = new ArrayList<Integer>();

    public MonthlyHabit() {
    }

    public MonthlyHabit(String name, String note, ArrayList<Integer> days) {
        super(name, note);
        this.days = days;
    }

    public CustomDate getDate() {
        return date;
    }

    public void setDate(CustomDate date) {
        this.date = date;
    }

    public ArrayList<Integer> getDays() {
        return days;
    }

    public void setDays(ArrayList<Integer> days) {
        this.days = days;
    }

    public void print()
    {
        System.out.print("\nActivity number " + this.getId() + "\nName: " + getName() + "\nStatus : " + getStatus() + "\nType: MonthlyHabit\nNote:" + getNote() + "\n");
        System.out.print("Days Active : ");

        for (int i = 0; i < days.size(); i++) {
            System.out.print(days.get(i) + " ");
        }
    }

    public void reset() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //getTime() returns the current date in default time zone
        Date date = calendar.getTime();
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        for (int idx : days) {
            if (dayOfMonth == idx) setStatus(false);
        }
    }
}
