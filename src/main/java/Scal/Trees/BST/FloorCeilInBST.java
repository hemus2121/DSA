package Scal.Trees.BST;

import  java.util.*;
import Scal.Trees.TreeNode;

/*
Problem Description

Given a Binary Search Tree rooted at A.
Given an integer array B of size N. Find the floor and ceil of every element of the array B.
Floor(X) is the highest element in the tree <= X, while the ceil(X) is the lowest element in the tree >= X.
NOTE: If floor or ceil of any element of B doesn't exists, output -1 for the value which doesn't exists.
 */
public class FloorCeilInBST {
    public ArrayList<ArrayList<Integer>> solve(TreeNode A, ArrayList<Integer> B) {

        ArrayList<ArrayList<Integer>> finalRes = new ArrayList<>();
        // iterate for B  for which we need to find
        for (int b : B){
            ArrayList<Integer> res = new ArrayList();
            res.add(floorValue(A, b));
            res.add(ceilValue(A, b));
             finalRes .add(res);
        }
        return finalRes;
    }

    //Floor - lower value when iterating to right
    public int floorValue(TreeNode A, int key){
        int floor=-1;
        TreeNode treeNode = A;
        while (treeNode!= null){

            if (treeNode.val==key){
                return treeNode.val;
            }

            if(treeNode.val < key){
                //current lowest value before going right
                floor= treeNode.val;
                treeNode = treeNode.right;
            }else{
                treeNode= treeNode.left;
            }
        }
        return floor;
    }

    // Ceil - Highest value when iterating left
    public int ceilValue(TreeNode A, int key){
        int ceil=-1;
        TreeNode treeNode =A;
        while (treeNode!=null){

            if (treeNode.val==key){
                return treeNode.val;
            }

            if (treeNode.val< key){
                treeNode= treeNode.right;
            }else{
                //current highest value before going right
                ceil = treeNode.val;
                treeNode = treeNode.left;
            }
        }
        return ceil;
    }
}
