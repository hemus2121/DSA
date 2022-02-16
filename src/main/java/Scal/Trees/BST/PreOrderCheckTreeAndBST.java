package Scal.Trees.BST;

/*
Problem Description

Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST),
where each internal node (non-leaf nodes) have exactly one child.
 */
public class PreOrderCheckTreeAndBST {

    private String checkPreOrderIsSameForTREEBST(int [] A){
        int left= Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;

        int root = A[0];

        //iterate for next set of elements
        for (int i =1;i< A.length;i++){

            //fixing boundary for each incoming element
            // if we go left then maximum will be right =  root value
            // if we go right then minimum will be left = root value
            if (A[i]<root){
                right = root;
            }else {
                left = root;
            }

            // BST condition is not satisfied return NO
            if (!((left <= A[i]) && (A[i]<=right))) return "NO";

            //continue with next value of incoming stream
            root = A[i];
        }
        return "YES";
    }
}
