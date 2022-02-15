package Scal.Trees.BST;

import Scal.Trees.TreeNode;

/*
Given a binary tree represented by root A.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.
2) The right subtree of a node contains only nodes with keys greater than the node's key.
3) Both the left and right subtrees must also be binary search trees.
 */
public class ValidBinarySearchTree {

    public int isValidBST(TreeNode A) {
        return checkBST(A, Integer.MIN_VALUE,Integer.MAX_VALUE)==true? 1:0;
    }

    public boolean checkBST(TreeNode A, int min, int max){
        //base case
        if (A==null) return true;

        //only if root node value is greater than min and less than max
        if (min<=A.val && A.val <= max){
            boolean left =checkBST(A, min, A.val-1);
            boolean right =checkBST(A, A.val+1, max);
            return left && right;
        }
        return  false;
    }

}
