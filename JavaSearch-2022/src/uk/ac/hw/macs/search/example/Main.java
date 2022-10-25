package uk.ac.hw.macs.search.example;

import uk.ac.hw.macs.search.*;

/**
 * Demonstrates how to use the provided classes.
 */
public class Main {

	private static Node addChild(int value, boolean goal, Node parent) {
		Node child = new Node(new IntState(value, goal));
		parent.addChild(child, 1);
		return child;
	}
	private static Node addChild(int x, int y, int cost, Node parent, Node target) throws Exception {
		Node child = new Node(new GridState(x, y, target));
		parent.addChild(child, cost);
		return child;
	}

	//Method to check if grid square is a wall for problem grid 1
	private static boolean isWallG1(int x, int y) {
		if ((x==2 && y==2) || (x==3 && y==2) || (x==4 && y==1)) return true;
		else return false;
	}

	//Method to check if grid square is a wall for problem grid 2
	private static boolean isWallG2(int x, int y) {
		if ((x==1 && y==1) || (x==2 && y==1) || (x==3 && y==1) || (x==2 && y==2)) return true;
		else return false;
	}

	//Method to check if grid square is grey for problem grid 1
	private static int squareCostG1(int x, int y) {
		if ((x == 1 && y == 0) || (x==1 && y ==1) || (x==2 && y==3) || (x==3 && y==3)) return 3;
		else return 1;
	}

	private static int squareCostG2(int x, int y) {
		if ((x == 0 && y == 1) || (x==4 && y ==1) || (x==1 && y==2) || (x==5 && y==2) || (x==1 && y==3) || (x==2 && y==3)) return 3;
		else return 1;
	}

	public static void main(String[] args) throws Exception {
		int gridCols = 6;
		int gridRows = 4;


		//Problem grid 1______
		Node goal = new Node(new GridState(4,2,true));

		//Init grid
		Node[][] grid = new Node[gridCols][gridRows];

		//Fill grid with nodes
		for (int x = 0; x < gridCols; x++) {
			for (int y = 0; y < gridRows; y++) {
					grid[x][y] = new Node(new GridState(x,y,goal));
			}
		}

		//Add goal node
		grid[4][2] = goal;

		//Link nodes
		for (int x = 0; x < gridCols; x++) {
			for (int y = 0; y < gridRows; y++) {

				//If square is a wall, ignore
				if (isWallG1(x,y)) continue;

				//Add flags
				boolean addLeft = true,addRight = true,addTop = true,addBott = true;

				//Check left
				if (x == 0) addLeft = false;
				//Check right
				if (x == 5) addRight = false;
				//Check above
				if (y == 0) addTop = false;
				//Check below
				if (y == 3) addBott = false;

				//Link children to current nod based on flags and check for walls
				if (addLeft && !isWallG1(x-1,y)) grid[x][y].addChild(grid[x-1][y],squareCostG1(x-1,y));
				if (addRight && !isWallG1(x+1,y)) grid[x][y].addChild(grid[x+1][y],squareCostG1(x+1,y));
				if (addTop && !isWallG1(x,y-1)) grid[x][y].addChild(grid[x][y-1],squareCostG1(x,y+1));
				if (addBott && !isWallG1(x,y+1)) grid[x][y].addChild(grid[x][y+1],squareCostG1(x,y-1));
			}
		}


		//Problem grid 2______
		Node goal2 = new Node(new GridState(3,3,true));

		//Init grid
		Node[][] grid2 = new Node[gridCols][gridRows];

		//Fill grid with nodes
		for (int x = 0; x < gridCols; x++) {
			for (int y = 0; y < gridRows; y++) {
				grid2[x][y] = new Node(new GridState(x,y,goal));
			}
		}

		//Add goal node
		grid2[4][2] = goal2;

		//Link nodes
		for (int x = 0; x < gridCols; x++) {
			for (int y = 0; y < gridRows; y++) {

				//If square is a wall, ignore
				if (isWallG2(x,y)) continue;

				//Add flags
				boolean addLeft = true,addRight = true,addTop = true,addBott = true;

				//Check left
				if (x == 0) addLeft = false;
				//Check right
				if (x == 5) addRight = false;
				//Check above
				if (y == 0) addTop = false;
				//Check below
				if (y == 3) addBott = false;

				//Link children to current nod based on flags and check for walls
				if (addLeft && !isWallG2(x-1,y)) grid2[x][y].addChild(grid2[x-1][y],squareCostG2(x-1,y));
				if (addRight && !isWallG2(x+1,y)) grid2[x][y].addChild(grid2[x+1][y],squareCostG2(x+1,y));
				if (addTop && !isWallG2(x,y-1)) grid2[x][y].addChild(grid2[x][y-1],squareCostG2(x,y+1));
				if (addBott && !isWallG2(x,y+1)) grid2[x][y].addChild(grid2[x][y+1],squareCostG2(x,y-1));
			}
		}

		//Run the search
		SearchOrder order = new AStarSearchOrder();
		SearchProblem problem = new SearchProblem(order);

		//Uncomment either row below for respective grid search

//		problem.doSearch(grid[0][0]);
		problem.doSearch(grid2[0][0]);
	}
}
