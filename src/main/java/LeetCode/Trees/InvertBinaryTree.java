package LeetCode.Trees;

import Blind75.Trees.TreeNode;

/** Invert Binary Tree --https://leetcode.com/problems/invert-binary-tree/
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree {
    public Blind75.Trees.TreeNode invertTree(Blind75.Trees.TreeNode root) {
        return treeInversion(root);
    }

    static Blind75.Trees.TreeNode treeInversion(Blind75.Trees.TreeNode root){
        // Base Case
        if(root == null ) return null;

        //MainLogic - using POST order traversal
        treeInversion(root.left);
        treeInversion(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
