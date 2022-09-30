package Scal.Trees;
/** Symmetric Binary Tree
 * Problem Description
 *
 * Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */

import Scal.Trees.TreeNode;


public class SymmetricBinaryTree {
    public int isSymmetric(TreeNode A) {
        if (A== null) return 1;
        return checkSymmetric(A.left, A.right) ? 1 : 0;
    }
    static boolean checkSymmetric (TreeNode A, TreeNode B){
        if (A== null && B ==null) return true;
        if (A== null || B ==null) return false;
        if (A.val != B.val) return false;
        return checkSymmetric (A.left, B.right) && checkSymmetric(A.right, B.left);
    }
}
