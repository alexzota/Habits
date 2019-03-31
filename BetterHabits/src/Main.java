public class Main {

    public static void main(String[] args)
    {
        PersonalAgenda pA = new PersonalAgenda();
        pA.addActivity(" Programare", "E ee");
        pA.addDailyhabit("Stat", "IAAAS", "Monday");
        pA.addActivity("mai bine nu", "intarzii");

        DailyHabit dH = new DailyHabit("Nu pierde", "Timpul", "Tuesday");
        dH.print();
        dH.setStatus(true);
        dH.print();
        dH.reset();


    }
}
