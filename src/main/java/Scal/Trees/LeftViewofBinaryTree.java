package Scal.Trees;

/** Print Left View of the Tree
 * Using Prev pointer
 * TC: O(N): using level wise traversing
 * SC: O(n)
 */
import Scal.Trees.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewofBinaryTree {
    public static ArrayList<Integer> leftView(TreeNode root) {

        // Using concept of Level order traversal only - with additional prev pointer

        // Boundary condition
        if (root == null || root.val == -1) {
            return null;
        }

        Queue<TreeNode> que = new LinkedList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        //Maintain prev pointer
        TreeNode prev = null;

        que.add(root);
        que.add(null);

        while (que.size() >1) {
            TreeNode temp = que.poll();

            if (temp==null){ //level end here
                que.add(null);
                prev =temp;
                continue;
            }
            // temp is first node on left
            if (prev ==null)
                resultList.add(temp.val);
            prev = temp; // update prev variable
            if (temp.left != null) que.add(temp.left);
            if (temp.right != null) que.add(temp.right);
        }
        return  resultList;
    }
    public static void main(String[] args) {
    }
}
