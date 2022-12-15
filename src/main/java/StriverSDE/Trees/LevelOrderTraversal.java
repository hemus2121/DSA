package StriverSDE.Trees;

import Scal.Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Level order Traversal of Binary Tree without using null marker
 * Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.
 * TC : SC : O(N)
 */
public class LevelOrderTraversal {
    public List<Integer> levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();
        //edge case
        if (root == null) return resultList;

        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            resultList.add(node.data);// add current node data to result list

            if (node.left != null)
                q.add(node.left);

            if (node.right!=null)
                q.add(node.right);
        }
        return resultList;
    }
}
