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

	private static boolean isEdge(int x, int y) {
		if ((x<1 || x>4) && (y<1 || y>2)) return true;
		else return false;
	}

	private static int squareCostG1(int x, int y) {
		if ((x == 1 && y == 0) || (x==1 && y ==1) || (x==2 && y==3) || (x==3 && y==3)) return 3;
		else return 1;
	}

	public static void main(String[] args) throws Exception {
		// Create some states
//		Node root = new Node(new IntState(0));
//		Node goal = new Node(new IntState(5, true));
//		Node child = addChild(1, false, root);
//		child = addChild(2, false, child);
//		child = addChild(3, false, child);
//		addChild(4, false, child);
//		root.addChild(goal, 1);

		int gridCols = 6;
		int gridRows = 4;

		//Problem grid 1______
		Node goal = new Node(new GridState(4,2,true));

		//Init grid
		Node[][] firstGrid = new Node[gridCols][gridRows];

		//Fill grid
		for (int x = 0; x < gridCols; x++) {
			for (int y = 0; y < gridRows; y++) {

				//If black square, don't add node	MAYBE SET TO EMPTY NODE OR SOMETHING
				if ((x==2 && y==2) || (x==3 && y==2) || (x==4 && y==1)) {}

				//Else fill with node
				else
					firstGrid[x][y] = new Node(new GridState(x,y,goal));
			}
		}

		//Add goal
		firstGrid[4][2] = goal;

		//Link nodes
		for (int x = 0; x < gridCols; x++) {
			for (int y = 0; y < gridRows; y++) {

				//If square is black
				if (firstGrid[x][y]==null) continue;

				//Add flags
				boolean addLeft = true,addRight = true,addTop = true,addBott = true;
				//Check left
				if (x == 0) addLeft = false;
				//Check right
				if (x == 5) addRight = false;
				//Check Top
				if (y == 0) addTop = false;
				//Check Bottom
				if (y == 3) addBott = false;
				if (addLeft) firstGrid[x][y].addChild(firstGrid[x-1][y],squareCostG1(x-1,y));
				if (addRight) firstGrid[x][y].addChild(firstGrid[x+1][y],squareCostG1(x+1,y));
				if (addTop) firstGrid[x][y].addChild(firstGrid[x][y-1],squareCostG1(x,y+1));
				if (addBott) firstGrid[x][y].addChild(firstGrid[x][y+1],squareCostG1(x,y-1));
			}
		}




//		//Row 2 Header Node
//		Node r2 = addChild(1,2,1,root,goal);

//		//First 2 rows . . .
//		Node child = addChild(2,1,2,root, goal);
//		Node child2 = addChild(2,2,2,r2, goal);
//		child = addChild(3,1,1,child,goal);
//		child2 = addChild(3,2,1,child,goal);
//		child = addChild(4,1,1,child,goal);
//		child2 = addChild(4,2,1,child,goal);
//		child = addChild(5,1,1,child,goal);
//		child2 = addChild(5,2,3,child,goal);
//		child = addChild(6,1,1,child,goal);
//		child2 = addChild(6,2,1,child,goal);
//
//		//Second 2 rows . . .
//		child = addChild(1,3,1,r2,goal);
//		child2 = addChild(1,4,1,child,goal);
//		child = addChild(2,3,1,child,goal);
//		child2 = addChild(2,4,1,child,goal);
//		child = addChild(3,3,3,child,goal);
//		child2 = addChild(3,4,2,child,goal);
//		child = addChild(4,3,3,child,goal);
//		child2 = addChild(4,4,2,child,goal);
//		child.addChild(goal,1);
//		child = goal;
//		child2 = addChild(5,4,1,goal,goal);
//		child = addChild(6,3,1,goal,goal);
//		child2 = addChild(6,4,1,child,goal);

		// Run the search
		SearchOrder order = new AStarSearchOrder();
		SearchProblem problem = new SearchProblem(order);
		problem.doSearch(firstGrid[0][0]);


//		SearchOrder order = new BreadthFirstSearchOrder();
//		SearchProblem problem = new SearchProblem(order);
//		problem.doSearch(root);
	}
}
