package Scal.Trees.BST;

//Reference- well explained
//https://www.youtube.com/watch?v=9deLPrlUwpA

import Scal.Trees.TreeNode;

public class NodesInRange {

    int count =0;
    public int solve(TreeNode A, int B, int C) {
        return countRangeNumbers(A, B,C);
    }

    public int countRangeNumbers(TreeNode A, int l , int r){
        if (A== null) return 0;
        if ( l <=A.val && A.val<=r) count++;

        //Condition if left range is LESSER than root elements can exists in left subtree
        if (l<A.val){
            countRangeNumbers(A.left,l, r);
        }
        ///Condition if right range is GREATER than root elements can exists in right subtree
        if ( r > A.val){
            countRangeNumbers(A.right,l, r);
        }
        return count;
    }
}
