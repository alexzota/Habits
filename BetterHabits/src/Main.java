import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args)
    {
        PersonalAgenda pA = new PersonalAgenda();

        pA.addActivity(" Programare", "E ee");
        pA.addDailyhabit("Stat", "IAAAS", "Monday");

        ArrayList<String> days = new ArrayList<String>();
        days.add("monday");
        days.add("tuesday");
        days.add("friday");

        pA.addWeeklyhabit("Curatenie", "Pe jos si in inima", days);

        ArrayList<Integer> days1 = new ArrayList<Integer>();
        days1.add(2);
        days1.add(15);

        pA.addMonthlyHabit("PAO", "Nice", days1);

        ArrayList<CustomDate> dates = new ArrayList<CustomDate>();
        dates.add(new CustomDate(2,7));
        dates.add(new CustomDate(17,1));

        pA.addYearlyHabit("Achilles", "His backheel", dates);

        Exercise ex = new Exercise("Deadlift", 1, 5, 75);
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        exercises.add(ex);
        Workout wk = new Workout( 2, exercises );
        ArrayList<Workout> wkts = new ArrayList<Workout>();
        wkts.add(wk);
        pA.addGym("Strong in body and mind", "Work", days, wkts);


        Course course1 = new Course("PAO", 1200, 1400);
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(course1);

        SchoolDaySchedule sds1 = new SchoolDaySchedule(2, courses);
        ArrayList<SchoolDaySchedule>  schedules = new ArrayList<SchoolDaySchedule>();
        schedules.add(sds1);
        Date date = new Date();
        Date date1 = new Date();

        ArrayList<String> contributors = new ArrayList<String>();
        contributors.add("Alex");

        Project project1 = new Project("test AI", date, date1, contributors, "invata" );
        ArrayList<Project> projects = new ArrayList<Project>();
        projects.add(project1);
        pA.addSchool("Facultate", "The pen is mightier", days, projects, schedules );


        pA.addJob("Software intern", "Internship de vaar", days, projects);

        pA.printActivities();


    }
}

