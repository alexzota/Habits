package habits.configuration;

import habits.domain.repository.*;

import java.io.FileNotFoundException;

public class RepositoryConfig {
    private ActivityRepository activityRepository = null;
    private YearlyHabitRepository yearlyHabitRepository = null;
    private static RepositoryConfig Instance = new RepositoryConfig();

    private RepositoryConfig() {
        activityRepository = new ActivityRepositoryDB();
        yearlyHabitRepository = new YearlyHabitRepositoryDB();
    }

    public ActivityRepository getActivityRepository() {
        return activityRepository;
    }

    public static RepositoryConfig getInstance() {
        return Instance;
    }

    public YearlyHabitRepository getYearlyHabitRepository() {
        return yearlyHabitRepository;
    }
}