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

            newNode.getFValue();
//            frontier.add(0,new FringeNode(child.node, parent, child.cost));
        }

    }
}
