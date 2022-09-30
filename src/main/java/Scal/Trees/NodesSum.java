package Scal.Trees;


public class NodesSum {

    public int solve(TreeNode A) {
        return sum(A);
    }
    private static int sum(TreeNode A){
        return sum(A.left) + A.val + sum(A.right);
    }
}
