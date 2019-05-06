package habits.configuration;

import habits.domain.repository.*;

import java.io.FileNotFoundException;

public class RepositoryConfig {
    private ActivityRepository activityRepository = null;
    private static RepositoryConfig Instance = new RepositoryConfig();

    private RepositoryConfig() {
        try {
            activityRepository = new ActivityRepositoryFile("DailyHabits.csv", "WeeklyHabits.csv", "MonthlyHabits.csv", "YearlyHabits.csv");
        }
        catch (FileNotFoundException e) {
            System.out.println("Incorrect file path!");
        }
    }

    public ActivityRepository getActivityRepository() {
        return activityRepository;
    }

    public static RepositoryConfig getInstance() {
        return Instance;
    }

}