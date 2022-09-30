package Scal.Trees.BST;

import Scal.Trees.*;
/*
Given a binary tree represented by root A.

        Assume a BST is defined as follows:

        1) The left subtree of a node contains only nodes with keys less than the node's key.
        2) The right subtree of a node contains only nodes with keys greater than the node's key.
        3) Both the left and right subtrees must also be binary search trees.
 */
public class ValidBinarySearchTreeBottomUp {
    class Data{
        long min, max ;
        boolean result;
        public Data(){
            min = 1 + (long)Integer.MAX_VALUE;
            max =-1;
            result =true;
        }
    }

    public int isValidBST(TreeNode A){
        Data data = checkNode(A);
        return data.result ? 1:0;
    }

    public Data checkNode(TreeNode A){
        //init values
        Data data = new Data();
        //Base case
        if (A==null) return data;

        //Post order traversal kind
        Data left_data = checkNode(A.left);
        Data right_data = checkNode(A.right);

        if(left_data.result==true && right_data.result==true){
            //now do BST comparison
            if(left_data.max <A.val && A.val < right_data.max){
                //update min and max values from both side
                data.min= Math.min(left_data.min, A.val);
                data.max = Math.max(right_data.max, A.val);
            }else {
                data.result=false;
            }
        }else {
            data.result= false;
        }
        return  data;
    }
}
