package Scal.Trees.BST;

/**
Problem Description

Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST),
where each internal node (non-leaf nodes) have exactly one child.
 */
public class PreOrderCheckTreeAndBST {

    static String checkPreOrderIsSameForTREEBST(int [] A){
        int left= Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;

        int root = A[0];

        //iterate for next set of elements
        for (int i =1;i< A.length;i++){

            // fixing boundary for each incoming element
            // if we go left then maximum will be right =  root value
            // if we go right then minimum will be left = root value
            if (A[i]<root){
                right = root;
            }else {
                left = root;
            }

            // BST condition is not satisfied return NO
            if(A[i]<left || A[i]>right) return "NO";

            //continue with incoming element
            root = A[i];
        }
        return "YES";
    }

    public static void main(String[] args) {
        int [] A= {4, 10 , 5, 8};
        System.out.println(checkPreOrderIsSameForTREEBST(A)); //expected 'YES'

        int [] B = {1,5,6,4};
        System.out.println(checkPreOrderIsSameForTREEBST(B)); //expected 'NO'
    }
}
