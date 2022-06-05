package Scal.Trees.Trees2;

/** Balance Binary Tree
  * Problem Description
  *  Given a root of binary tree A, determine if it is height-balanced.
  * A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
import Scal.Trees.TreeNode;

public class BalancedBinaryTree {
    public int isBalanced(TreeNode A) {
        return isTreeBalanced(A);
    }

    private static int isTreeBalanced(TreeNode A){
        //Base case
        if (A==null) return 1;

        //Main logic
        if (Math.abs(getHeight(A.left) - getHeight(A.right)) > 1) return 0;
        return ( isTreeBalanced(A.left)==1 && isTreeBalanced(A.right)==1)?1:0;
    }

    static int getHeight(TreeNode A){
        if (A== null) return 0;
        return 1+ Math.max( getHeight(A.left), getHeight(A.right));
    }
}
