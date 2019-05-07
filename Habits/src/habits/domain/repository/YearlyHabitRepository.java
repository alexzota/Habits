package habits.domain.repository;

import habits.domain.entity.YearlyHabit;

import java.util.TreeSet;

public interface YearlyHabitRepository {
    public TreeSet<YearlyHabit> getYearlyHabits();
    public YearlyHabit getYearlyHabitById(int idd);

}
