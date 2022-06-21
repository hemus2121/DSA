package LeetCode.Trees;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Binary Tree Level order Traversal
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        // edge case
        if (root == null) return null;

        //Using Iterative way of Traversal
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);
        que.add(null);
        while ( que.size() >1){

            TreeNode temp = que.poll();

            // level marker
            if (temp ==null){
                que.add(null);
                resultList.add(tempList); // add the current list value to final result
                tempList = new ArrayList<>(); //reset for next set of values
                continue;
            }
            // Add the current value to tempList
            tempList.add(temp.val);

            //add left and right children to Queue
            if (temp.left != null) que.add(temp.left);
            if (temp.right != null) que.add(temp.right);
        }

        if (tempList != null){
            resultList.add(tempList);
        }
        return  resultList;
    }

}
