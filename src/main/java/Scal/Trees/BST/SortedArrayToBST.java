package Scal.Trees.BST;

import Scal.Trees.TreeNode;
/*
Problem Description

Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */

public class SortedArrayToBST {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final int[] A) {

        if (A.length==1) return new TreeNode( A[0]);
        return buildTreeFromArray(A, 0, A.length-1);
    }

    public TreeNode buildTreeFromArray(int[] A, int low, int high){
        //BASE condition to break
        if(low > high) return null;

        //get the middle element
        int mid = (low+high)/2;
        //Create root node
        TreeNode treeNode = new TreeNode(A[mid]);

        //recursively call same function for left half (low - mid-1)
        treeNode.left = buildTreeFromArray(A, low, mid-1);

        //recursively call same function for left half (low - mid-1)
        treeNode.right = buildTreeFromArray(A, mid+1, high);

        return treeNode;
    }
}
