package Scal.Trees.Trees2;
/** Invert Binary Tree
 * Problem Description
 * Given a binary tree A, invert the binary tree and return it.
 *
 * Inverting refers to making the left child the right child and vice versa.
 */

import Scal.Trees.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode A) {
        return treeInverse(A);
    }

    static TreeNode treeInverse(TreeNode A){
        //Base case
        if (A == null) return null ;


        //Main Logic-Using POST order Traversal
        treeInverse(A.left);
        treeInverse(A.right);

        //Swap nodes
        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;
        return A;
    }
}
