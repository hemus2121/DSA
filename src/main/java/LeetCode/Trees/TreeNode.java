package LeetCode.Trees;

public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }

        @Override
        public String toString() {
            return " " + val + " " + left +  " " + right ;
        }
}
