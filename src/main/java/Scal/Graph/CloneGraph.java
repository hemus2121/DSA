package Scal.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CloneNode {
    public int val;
    public List<CloneNode> neighbors;

    public CloneNode() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public CloneNode(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public CloneNode(int _val, ArrayList<CloneNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {

    //Map to contain mapping of old and new nodes references
    static Map<CloneNode, CloneNode> nodeVisitedMap = new HashMap<>();
     public static CloneNode graphClone (CloneNode node){
         return cloneGraph(node);
    }

    //DFS Way
    static CloneNode  cloneGraph(CloneNode node){
         //Base case
        if (node ==null) return null;
        // If the node was already visited before.
        // Return the clone from the visited dictionary.
        if (nodeVisitedMap.containsKey(node)) return nodeVisitedMap.get(nodeVisitedMap.get(node));

        //Main logic
        // Create a clone for the given node.
        // Note that we don't have cloned neighbors as of now, hence [].
        CloneNode newNode = new CloneNode(node.val);
        // The key is original node and value being the clone node.
        nodeVisitedMap.put(node, newNode);

        // Iterate through the neighbors to generate their clones
        // and prepare a list of cloned neighbors to be added to the cloned node.
        for ( CloneNode  neighbor :  node.neighbors){
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }

}
