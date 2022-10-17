package StriverSDE.Trees.BST;

import StriverSDE.Trees.Node;

/** Ceil in BST
 * You are given a BST (Binary search tree) with’ N’ number of nodes and a value ‘X’. Your task is to find the greatest value node of the BST  which is smaller than or equal to  ‘X’.
 */
public class CeilInBST {

    public static int ceilInBST(Node root, int key){
        int ceil = -1;
        if (root == null ) return ceil;
        while (root != null){
           if (root.data == key){
               ceil = root.data;
               return ceil;
           }
           if (key > root.data ){
               root = root.right;
           }else {
               ceil = root.data;
               root = root.left;
           }
        }
        return ceil;
    }
}
