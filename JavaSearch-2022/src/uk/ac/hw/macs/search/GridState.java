package uk.ac.hw.macs.search;

import uk.ac.hw.macs.search.State;


public class GridState implements State{


    private int x, y;
    private int squareCost;
    private boolean goal;
    private int heuristic;

    public GridState(int x, int y) {
        this.x = x;
        this.y = y;
        this.squareCost = 1;
        this.goal = false;
        this.heuristic = 0;
    }

    public GridState(int x, int y, int squareCost) {
        this.x = x;
        this.y = y;
        this.squareCost = squareCost;
        this.goal = false;
        this.heuristic = 0;
    }

    public GridState(int x, int y, int squareCost, boolean goal) {
        this.x = x;
        this.y = y;
        this.squareCost = squareCost;
        this.heuristic = 0;
        this.goal = goal;
    }

    public GridState(int x, int y, int squareCost, boolean goal, Node target) throws Exception {
        this.x = x;
        this.y = y;
        this.squareCost = squareCost;
        this.goal = goal;
        this.heuristic = calculateHeuristic(target);
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
    private int calculateHeuristic(Node target) throws Exception {

        //Check that target node is indeed the goal node, if not then throw exception
        if (!target.isGoal()) {
            throw new Exception("Node is not a goal node, can't calculate heuristic");
        }

//        int manhattenDistance = Math.abs(target.getValue().

        return 0;
    }

}
