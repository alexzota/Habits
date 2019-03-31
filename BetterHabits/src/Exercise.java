import java.util.ArrayList;

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
        System.out.print(sets + "x" + reps + "-" + weight );
    }
}
