package habits.domain.entity;

public class Activity {
    private static int idx = 1;
    private int id = 1;
    private String name;
    private String note = "";
    private boolean status = false;

    public Activity(){
        String temp = "Activity " + id;
        this.name= temp;
        this.id = idx;
        idx++;
    }

    public Activity(String name){
        this.name = name;
        this.id = idx;
        idx++;
    }

    public Activity(String name, String note){
        this.name = name;
        this.note = note;
        this.id = idx;
        idx++;
    }
    public static int getIdx() {
        return idx;
    }

    public static void setIdx(int idx) {
        Activity.idx = idx;
    }

    public int getId(){
        return id;
    }
    public void setId(int idx){
        id = idx;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public int dayStringToInt(String day){
        int intDay;
        day = day.toLowerCase();
        switch (day){
            case "monday": { intDay = 1; break; }
            case "tuesday": { intDay = 2; break; }
            case "wednesday": { intDay = 3; break; }
            case "thursday": { intDay = 4; break; }
            case "friday": { intDay = 5; break; }
            case "saturday": { intDay = 6; break; }
            case "sunday": { intDay = 7; break; }
            default : {intDay = 0; break;}
        }
        return intDay;
    }

    public int monthStringToInt(String month){
        int intMonth;
        month = month.toLowerCase();
        switch (month){
            case "january": { intMonth = 1; break; }
            case "february": { intMonth = 2; break; }
            case "march": { intMonth = 3; break; }
            case "april": { intMonth = 4; break; }
            case "may": { intMonth = 5; break; }
            case "june": { intMonth = 6; break; }
            case "july": { intMonth = 7; break; }
            case "august": { intMonth = 8; break; }
            case "september": { intMonth = 9; break; }
            case "october": { intMonth = 10; break; }
            case "november": { intMonth = 11; break; }
            case "december": { intMonth = 12; break; }
            default : {intMonth = 0; break;}
        }
        return intMonth;
    }
    public void print(){
        System.out.print("\nActivity number " + this.id + "\nName: " + name +"\nStatus : " + status + "\nNote:" + note+"\n");
    }
    public void reset(){}
}

