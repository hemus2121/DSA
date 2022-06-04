package Blind75.Trees;

/** Invert Binary Tree --https://leetcode.com/problems/invert-binary-tree/
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        return treeInversion(root);
    }

    static TreeNode treeInversion(TreeNode root){
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
