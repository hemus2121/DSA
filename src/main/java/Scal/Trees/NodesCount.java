package Scal.Trees;

/* Problem Description
You are given the root node of a binary tree A. You have to find the number of nodes in this tree.
 */
public class NodesCount {
    public int count(TreeNode A) {
        return countNodes(A);
    }
    public int countNodes(TreeNode A){

        //Base case-Empty node return 0
        if (A==null) return 0;

        // count nodes on left and right side + 1 for root node
        return countNodes(A.left)+ countNodes(A.right)+1;
    }
}
