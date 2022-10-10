package StriverSDE.Trees;

/** Diameter of Tree
 * Problem Statement: Find the Diameter of a Binary Tree. Diameter is the length of the longest path between any 2 nodes in the tree and this path may or may not pass from the root.
 * TC :SC : O(N)
 **/
public class DiameterOfTree {

    int diameter =0;
    private int computeDiaMeter(Node root){
        computeHeight(root);
        return diameter;
    }
    int computeHeight(Node root){
        //base case
        if (root == null) return -1;// this is important since we are computing based on edge
        int left = computeHeight(root.left);
        int right = computeDiaMeter(root.right);
        diameter = Math.max(diameter, left+right+2);
        return Math.max(left,right)+1;
    }
}
