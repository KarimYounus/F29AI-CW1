package uk.ac.hw.macs.search;

public class HeuristicState implements State{


    private int value;
    private int heurtistic;
    private boolean goal;

    public HeuristicState (int value) {
        this.value = value;
        this.heurtistic = 0;
        this.goal = false;
    }

    public HeuristicState (int value, int heurtistic) {
        this.value = value;
        this.heurtistic = heurtistic;
        this.goal = false;
    }

    public HeuristicState (int value, int heurtistic, boolean goal) {
        this.value = value;
        this.heurtistic = heurtistic;
        this.goal = goal;
    }

    @Override
    public boolean isGoal() {
        return this.goal;
    }

    //Calculated using Manhattan distance
    @Override
    public int getHeuristic() {
        return this.heurtistic;
    }
}
