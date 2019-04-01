import java.util.ArrayList;
import java.util.Date;

public class Project {
    private Date startingDate = new Date();
    private Date deadline = new Date();
    private String name = "";
    private ArrayList<String> contributors = new ArrayList<String>();
    private String note = "";


    public Project(){}
    public Project(String name, Date startingDate,  Date deadline, ArrayList<String> contributors, String note ){

        this.name = name;
        this.startingDate = startingDate;
        this.deadline = deadline;
        this.contributors = contributors;
        this.note = note;
    }
    public void print(){
        System.out.print("\nProject : " + this.getName() +"\nStatus : \nContributors: " +  "\nNote:" + getNote()+"\n");
        System.out.println();
    }
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ArrayList<String> getContributors() {
        return contributors;
    }

    public void setContributors(ArrayList<String> contributors) {
        this.contributors = contributors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }
}
