package visa.Trees;


//https://leetcode.com/problems/path-sum-iii/description/
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class PathSumIII {
    static int counter=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root ==null) return 0;
        //PRE ORDER Traversal
        pathSumHelper(root,targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right, targetSum);
        return  counter;
    }

    static void pathSumHelper(TreeNode root, int targetSum, int currentSum){
        if (root==null) return ;
        currentSum += root.val;
        //check if current sum == targetSum
        if (currentSum== targetSum) counter++;
        pathSumHelper(root.left,targetSum, currentSum);
        pathSumHelper(root.right, targetSum, currentSum);
    }
}
