package uk.ac.hw.macs.search;

import java.util.List;
import java.util.Set;

/* Implementation of A* search algorithm*/

public class AStarSearchOrder implements SearchOrder{
    @Override
    public void addToFringe(List<FringeNode> frontier, FringeNode parent, Set<ChildWithCost> children) {
        //For loop to loop through children to be added to fringe
        for (ChildWithCost child : children) {
            boolean insert = true;

            //Nodes need to be added in order of increase f value (cost + heuristic cost)

            //New node to be added to Fringe
            FringeNode newNode = new FringeNode(child.node, parent, child.cost);

            //Get fVal of node to be added to fringe
            int currentFVal = newNode.getFValue();

            /*Sorted insertion of nodes into fringe by order of increasing fVal*/

            //If fringe is empty, simply add
            if (frontier.isEmpty()) {
                frontier.add(newNode);
                continue;
            }

            //If inserting into head of list
            if (currentFVal < frontier.get(0).getFValue()) {
                frontier.add(0, newNode);
                continue;
            }

            //Else sorted insert into middle of list
            for (int i = 1; i < frontier.size(); i++) {
                if (currentFVal < frontier.get(i).getFValue()) {
                    frontier.add(i-1, newNode);
                    insert = false;
                    break;
                }
            }

            //Else add to end
            if(insert) frontier.add(frontier.size()-1, newNode);
        }
    }
}
