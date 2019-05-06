package habits;

import habits.services.PersonalAgendaService;

public class Start {
    public static void main(String[] args) {
        PersonalAgendaService personalAgenda = new PersonalAgendaService();
        personalAgenda.printActivities();
        personalAgenda.resetActivities();
        personalAgenda.printCompletedActivities();
        personalAgenda.printUncompletedActivities();
        personalAgenda.printDailyHabits();
    }
}
