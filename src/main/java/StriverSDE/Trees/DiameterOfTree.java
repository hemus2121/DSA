package StriverSDE.Trees;

/** Diameter of Tree
 * Problem Statement: Find the Diameter of a Binary Tree. Diameter is the length of the longest path between any 2 nodes in the tree and this path may or may not pass from the root.
 * TC :SC : O(N)
 **/
public class DiameterOfTree {

    private int computeDiaMeter(Node root){
        int [] diameter = new int [1];
        computeHeight(root, diameter);
        return diameter[0];
    }
    int computeHeight(Node root, int [] diameter){
        //base case
        if (root == null) return -1;// this is important since we are computing based on edge
        int left = computeHeight(root.left, diameter);
        int right = computeHeight(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left+right);
        return 1 + Math.max(left,right);
    }
}
