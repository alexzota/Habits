import java.util.ArrayList;

public class Job extends WeeklyHabit {
    private ArrayList<Project> projects = new ArrayList<Project>();

    public Job(){}
    public Job(String name, String note, ArrayList<String> days, ArrayList<Project> projects){
        super(name,note,days);
        this.projects = projects;
    }

    public void print(){
        System.out.print("\nActivity number " + this.getId() +"\nName: " + getName() +"\nStatus : " + getStatus()+ "\nType: Job\nNote:" + getNote()+"\n");
        System.out.print("Days Active : ");

        for( int idx : this.getDays()) {
            System.out.print(idx + " ");
        }
        System.out.println();

        System.out.print("Projects Active : ");

        for( Project idx : this.getProjects()) {
            idx.print();
        }
        System.out.println();
    }

    public void addProject( Project pj ){
        projects.add(pj);
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
}
