package habits;

import habits.services.PersonalAgendaService;

public class Start {
    public static void main(String[] args) {
        PersonalAgendaService personalAgenda = new PersonalAgendaService();
        personalAgenda.updateMonthlyHabit(15, "14,25");
        personalAgenda.printActivities();
    }
}
