package Scal.Trees.Trees2;

import Scal.Trees.TreeNode;

/** Sum binary tree or not
 * Problem Description
 *
 * Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.
 * Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.
 * An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
 * Return 1 if it sum-binary tree else return 0.
 */
public class SumBinaryTree {

    public int solve(TreeNode A) {
        return isSumTree(A) >0 ? 1:0;
    }

    //The idea is to traverse the tree in a POSTORDER fashion. For each non-leaf node,
    //check if the nodes value is equal to the sum of all elements present in its left and right subtree.
    //If this relation does not hold for any node, then the given binary tree cannot be a sum tree.
    public int isSumTree (TreeNode A){
        //Base case
        if (A == null) return 0;
        if (A.left ==null && A.right == null) return A.val;

        //Main Logic - get left and right sum and check if that sum is Equal to current Node sum

        int leftSum = isSumTree(A.left);
        int rightSum = isSumTree(A.right);
        //if left + right= current node value return twice of node value
        if (leftSum +rightSum == A.val) return 2 *A.val;

        return  Integer.MIN_VALUE;
    }
}
