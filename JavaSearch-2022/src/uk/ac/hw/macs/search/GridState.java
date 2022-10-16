package uk.ac.hw.macs.search;

public class GridState implements State{


    private int x, y;
    private int squareCost;
    private int heuristic;
    private boolean goal;

    public GridState(int x, int y) {
        this.x = x;
        this.y = y;
        this.squareCost = 1;
        this.heuristic = 0;
        this.goal = false;
    }

    public GridState(int x, int y, int squareCost) {
        this.x = x;
        this.y = y;
        this.squareCost = squareCost;
        this.heuristic = 0;
        this.goal = false;
    }

    public GridState(int x, int y, int squareCost, int heuristic) {
        this.x = x;
        this.y = y;
        this.squareCost = squareCost;
        this.heuristic = heuristic;
        this.goal = false;
    }

    public GridState(int x, int y, int squareCost, int heuristic, boolean goal) {
        this.x = x;
        this.y = y;
        this.squareCost = squareCost;
        this.heuristic = heuristic;
        this.goal = goal;
    }

    //Returns coordinates in int array
    public int[] getXY() {
        return new int[] {this.x, this.y};
    }

    public int getSquareCost() {
        return this.squareCost;
    }

    @Override
    public int getHeuristic() {
        return this.heuristic;
    }

    @Override
    public boolean isGoal() {
        return this.goal;
    }

    //Calculated using Manhattan distance
    private int calculateHeuristic() {

        return 0;
    }

}
