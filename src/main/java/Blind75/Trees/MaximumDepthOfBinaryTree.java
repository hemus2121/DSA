package Blind75.Trees;

/** Maximum Depth of Binary Tree - https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        //Base Case
        if (root == null) return 0;

        // Main logic
        return Math.max(maxDepth(root.left) , maxDepth(root.right))+1;
    }
}
