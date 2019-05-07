package habits.domain.repository;

import habits.domain.entity.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class YearlyHabitRepositoryFile implements YearlyHabitRepository{
    private TreeSet<YearlyHabit> yearlyHabits = new TreeSet<YearlyHabit>();

    public YearlyHabitRepositoryFile(String fisier1) throws FileNotFoundException {

        FileInputStream inputStream = new FileInputStream(fisier1);
        Scanner scanner1 = new Scanner(inputStream);

        while(scanner1.hasNext()){
            String linie = scanner1.nextLine();
            String[] valori = linie.split(",");
            CustomDate date = new CustomDate(Integer.parseInt(valori[2]), Integer.parseInt(valori[3]));
            ArrayList<CustomDate> dates = new ArrayList<CustomDate>();
            dates.add(date);
            yearlyHabits.add(new YearlyHabit(valori[0], valori[1], dates));
        }
    }

    public TreeSet<YearlyHabit> getYearlyHabits(){
        return yearlyHabits;
    }
    public YearlyHabit getYearlyHabitById(int idd){
        Iterator<YearlyHabit> idx = yearlyHabits.iterator();
        while ( idx.hasNext()){
            YearlyHabit temp = idx.next();
            if (temp.getId() == idd ) return temp;
        }
        return null;
    }


}
