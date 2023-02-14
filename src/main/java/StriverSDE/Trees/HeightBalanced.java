package StriverSDE.Trees;

/**
 * Check if the Binary Tree is Balanced Binary Tree
 * Problem Statement: Check whether the given Binary Tree is a Balanced Binary Tree or not. A binary tree is balanced if, for all nodes in the tree, the difference between left and right subtree height is not more than 1.
 * TC: O(N)
 * SC: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree)
 */
public class HeightBalanced {

    public boolean  isTreeBalanced(Node root) {
        return dfsHeight(root) != -1;
    }

    int dfsHeight(Node root){
        //base case
        if (root == null) return 0;

        //main logic
        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return  -1;
        //check abs difference
        if (Math.abs(leftHeight - rightHeight)>1) return -1;
        return Math.max(leftHeight,rightHeight) +1;
    }
}
