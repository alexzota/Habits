package habits;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import habits.domain.entity.Activity;
import habits.services.PersonalAgendaService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Start {
    public static void main(String[] args) {
        PersonalAgendaService personalAgenda = new PersonalAgendaService();


//        personalAgenda.addDailyHabit("Daily Habit 1", "Note of Daily Habit1", false, 2);
//        personalAgenda.addWeeklyHabit("Weekly Habit 1", "Note of WH1", false, "3,5");
//        personalAgenda.addMonthlyHabit("Monthly Habit 1", "Note of MH 1", false, "1,9,15");
//        personalAgenda.addYearlyHabit("Yearly Habit 1", "Note", false, "16-09,23-06");






        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame window = new JFrame("Habits");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600,600);
        window.setLayout(new BorderLayout());

        final CardLayout cardLayout = new CardLayout();
        final JPanel cardPanel = new JPanel(cardLayout);

        // create two dummy panels (the "cards") to show
        JPanel card1 = new JPanel();

        String[] columnNames = {"Id",
                "Name",
                "Note",
                "Status",
                "Day/s"
        };
        DefaultTableModel tableModel1 = new DefaultTableModel(columnNames, 0);
        for (Activity a : personalAgenda.getActivities()){
            int id = a.getId();
            String name = a.getName();
            String note = a.getNote();
            Boolean status = a.getStatus();

            Object[] data = new Object[]{id,name,note,status};
            tableModel1.addRow(data);
        }
        for (Activity a : personalAgenda.getYearlyHabits()){
            int id = a.getId();
            String name = a.getName();
            String note = a.getNote();
            Boolean status = a.getStatus();

            Object[] data = new Object[]{id,name,note,status};
            tableModel1.addRow(data);
        }
        JTable table1 = new JTable(tableModel1);
        JScrollPane sp1 = new JScrollPane(table1);
        sp1.setSize(400,500);
        card1.add(sp1);

        cardPanel.add(card1,"FirstCard");
        cardPanel.add(card1,"ListAllCard");

        JPanel card2 = new JPanel();
        DefaultTableModel tableModel2 = new DefaultTableModel(columnNames, 0);
        for (Activity a : personalAgenda.getDailyHabits()){
            int id = a.getId();
            String name = a.getName();
            String note = a.getNote();
            Boolean status = a.getStatus();

            Object[] data = new Object[]{id,name,note,status};
            tableModel2.addRow(data);
        }
        JTable table2 = new JTable(tableModel2);
        JScrollPane sp2 = new JScrollPane(table2);
        sp2.setSize(400,500);
        card2.add(sp2);

        JPanel card3 = new JPanel();
        DefaultTableModel tableModel3 = new DefaultTableModel(columnNames, 0);
        for (Activity a : personalAgenda.getWeeklyHabits()){
            int id = a.getId();
            String name = a.getName();
            String note = a.getNote();
            Boolean status = a.getStatus();

            Object[] data = new Object[]{id,name,note,status};
            tableModel3.addRow(data);
        }
        JTable table3 = new JTable(tableModel3);
        JScrollPane sp3 = new JScrollPane(table3);
        sp3.setSize(400,500);
        card3.add(sp3);



        JPanel card4 = new JPanel();
        DefaultTableModel tableModel4 = new DefaultTableModel(columnNames, 0);
        for (Activity a : personalAgenda.getMonthlyHabits()){
            int id = a.getId();
            String name = a.getName();
            String note = a.getNote();
            Boolean status = a.getStatus();

            Object[] data = new Object[]{id,name,note,status};
            tableModel4.addRow(data);
        }
        JTable table4 = new JTable(tableModel4);
        JScrollPane sp4 = new JScrollPane(table4);
        sp4.setSize(400,500);
        card4.add(sp4);



        JPanel card5 = new JPanel();
        DefaultTableModel tableModel5 = new DefaultTableModel(columnNames, 0);
        for (Activity a : personalAgenda.getYearlyHabits()){
            int id = a.getId();
            String name = a.getName();
            String note = a.getNote();
            Boolean status = a.getStatus();

            Object[] data = new Object[]{id,name,note,status};
            tableModel5.addRow(data);
        }
        JTable table5 = new JTable(tableModel5);
        JScrollPane sp5 = new JScrollPane(table5);
        sp5.setSize(400,500);
        card5.add(sp5);



        cardPanel.add(card1,"ListAllCard");
        cardPanel.add(card2,"DailyHabitsCard");
        cardPanel.add(card3,"WeeklyHabitsCard");
        cardPanel.add(card4,"MonthlyHabitsCard");
        cardPanel.add(card5,"YearlyHabitsCard");


        // create two buttons
        JPanel buttonPanel = new JPanel();
        JButton b1 = new JButton("All ctivities");
        JButton b2 = new JButton("Daily Habits");
        JButton b3 = new JButton("Weekly Habits");
        JButton b4 = new JButton("Monthly Habits");
        JButton b5 = new JButton("Yearly Habits");
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);

        // create action listeners for buttons
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cardLayout.show(cardPanel, "ListAllCard");
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cardLayout.show(cardPanel, "DailyHabitsCard");
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cardLayout.show(cardPanel, "WeeklyHabitsCard");
            }
        });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cardLayout.show(cardPanel, "MonthlyHabitsCard");
            }
        });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cardLayout.show(cardPanel, "YearlyHabitsCard");
            }
        });

        // add card & button panels to the main window
        window.add(cardPanel,BorderLayout.CENTER);
        window.add(buttonPanel,BorderLayout.SOUTH);
        window.setVisible(true);

    }
}

