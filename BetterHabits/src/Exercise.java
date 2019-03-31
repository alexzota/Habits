import java.util.ArrayList;
import java.util.Scanner;

public class Exercise {
    private String name = "";
    private int sets = 0;
    private int reps = 0;
    private float weight = 0;

    public Exercise(){}
    public Exercise(String name,int sets, int reps, float weight){

        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }
    public void set(){
        Scanner in = new Scanner(System.in);
        System.out.print("Name : ");
        name = in.nextLine();
        System.out.print("sets : ");
        sets = in.nextInt();
        System.out.print("reps : ");
        reps = in.nextInt();
        System.out.print("weight : ");
        weight = in.nextFloat();

    }
    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void print(){
        System.out.println(name);
        System.out.println(sets + "x" + reps + "-" + weight );
    }
}

