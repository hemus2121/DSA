package LeetCode.Trees;



/** Same Tree
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 **/
public class SameTree {
    private boolean isSameTree(TreeNode p, TreeNode q) {
        //Base Case
        if ( p == null && q == null) return true;
        if  (p == null || q == null) return false;

        //Main Logic
        if (p.val==q.val){
            return  isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
