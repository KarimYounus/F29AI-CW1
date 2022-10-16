package uk.ac.hw.macs.search;

import uk.ac.hw.macs.search.State;

/* A state representing grid locations and square value*/

public class GridState implements State{

    private int x, y, squareCost, heuristic;
    private boolean goal;
    
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

    public GridState(int x, int y, int squareCost, Node target) throws Exception {
        this.x = x;
        this.y = y;
        this.squareCost = squareCost;
        this.goal = false;
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
    public int calculateHeuristic(Node target) throws Exception {

        //Check that target node is indeed the goal node, if not then throw exception
        if (!target.isGoal()) {
            throw new Exception("Node is not a goal node, can't calculate heuristic");
        }

        /*Get goal node coordinates, note cast to GridState to access getXY methods (seems jank but not sure how else
        it can be done without changing State interface or Node class . . .)*/
        int[] goalXY = ((GridState) target.getValue()).getXY();

        //Calculate mDist
        return Math.abs(goalXY[0]-this.x) + Math.abs(goalXY[y]-this.y);
    }

}
