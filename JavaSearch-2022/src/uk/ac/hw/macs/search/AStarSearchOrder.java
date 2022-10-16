package uk.ac.hw.macs.search;

import java.util.List;
import java.util.Set;

/* Implementation of A* search algorithm*/

public class AStarSearchOrder implements SearchOrder{
    @Override
    public void addToFringe(List<FringeNode> frontier, FringeNode parent, Set<ChildWithCost> children) {
        //For loop to loop through children to be added to fringe
        for (ChildWithCost child : children) {
            //Nodes need to be added in order of increase f value (cost + heuristic cost)

            //New node to be added to Fringe
            FringeNode newNode = new FringeNode(child.node, parent, child.cost);

            //Get fVal of node to be added to fringe
            int fVal = newNode.getFValue();

            /*Sorted insertion of nodes into fringe by order of increasing fVal*/

            //If fringe is empty, simply add
            if (frontier.isEmpty()) frontier.add(newNode);

            //If inserting into head of list
            else if (fVal < frontier.get(0).getFValue()) frontier.add(0, newNode);

            //Else sorted insert into list
            else {
                for (int i = 1; i < frontier.size(); i++) {
                    FringeNode node = frontier.get(i);
                    if (fVal < node.getFValue()) frontier.add(i-1, newNode);
                }
            }
        }
    }
}
