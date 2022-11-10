package Scal.Trees;

/** Path Sum -II
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 */

public class NodesSum {

    public int solve(TreeNode A) {
        return sum(A);
    }
    private static int sum(TreeNode A){
        return sum(A.left) + A.val + sum(A.right);
    }
}
