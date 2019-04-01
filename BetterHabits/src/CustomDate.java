public class CustomDate {
    private int day = 0;
    private int week = 0;
    private int month = 0;
    private int year = 0;

    public CustomDate(){}
    public CustomDate(int day){
        this.day = day;
    }
    public CustomDate(int day, int month){
        this.day = day;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
    public void print(){
        System.out.print(day + "-" + week + "-" + month + "-" + year+"\n");
    }
}

