package habits.tool;

public class DateConverterStoI {
    public static int dayStringToInt(String day){
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
}
