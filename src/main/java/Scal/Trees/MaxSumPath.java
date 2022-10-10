package Scal.Trees;

/** Max Sum Path in Binary Tree
 * Problem Description
 * Given a binary tree T, find the maximum path sum.
 *
 * The path may start and end at any node in the tree.
 */
public class MaxSumPath {
    int maxSumPath = Integer.MIN_VALUE;

    public int maxSumPath(TreeNode node){
        computeMaxsumPath(node);
        return maxSumPath;
    }
    public int computeMaxsumPath(TreeNode node){
        if (node == null) return 0;
        int left = computeMaxsumPath(node.left);
        int right = computeMaxsumPath(node.right);
        maxSumPath = Math.max(maxSumPath, node.val+ Math.max(left, 0) +Math.max(right, 0));
        return node.val+ Math.max(0, Math.max(left,right));
    }
}
