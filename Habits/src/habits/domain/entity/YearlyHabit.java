package habits.domain.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class YearlyHabit extends Activity implements Comparable<YearlyHabit>{
    private String[] dates ;

    public YearlyHabit() {
    }

    public YearlyHabit(String name, String note, String[] dates) {
        super(name, note);
        this.dates = dates;
    }

    public String[] getDates() {
        return dates;
    }

    public void setDates(String[] dates) {
        this.dates = dates;
    }

    public void reset() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //getTime() returns the current date in default time zone
        Date date = calendar.getTime();
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int monthOfYear = calendar.get(Calendar.MONTH);
        for (String idx : dates) {

            int dateDayOfMonth = Integer.parseInt(idx.split("-")[0]);
            int dateMonth = Integer.parseInt(idx.split("-")[1]);
            if (dateDayOfMonth == dayOfMonth && dateMonth == monthOfYear) setStatus(false);
        }
    }
    public int compareTo(YearlyHabit object){
        if (this.getName().equals(object.getName())) return this.getNote().compareTo(object.getNote());
                                            return this.getName().compareTo(object.getName());
    }

    public String toString(){
        String outDates = new String();
        for (int i = 0; i < dates.length; i++) {
            outDates += (dates[i] + ", ");
        }
        return  "\nActivity number " + this.getId() + "\nName: " + getName() + "\nStatus : " + getStatus() +
                "\nType: YearlyHabit\nNote:" + getNote() + "\nDays Active : " + outDates;
    }
}
