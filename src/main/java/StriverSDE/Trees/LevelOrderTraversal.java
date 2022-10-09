package StriverSDE.Trees;

import Scal.Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Level order Traversal of Binary Tree without using null marker
 * TC : SC : O(N)
 * Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node node){
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        //edge case
        if (node == null) return resultList;

        q.add(node);
        while (!q.isEmpty()){
            int leveNumber = q.size();
            List<Integer> subList = new ArrayList<>();
            for (int i =0;i< leveNumber;i++){ //traversal for q elements present
                Node tmp = q.poll();
                if (tmp.left != null) q.add(tmp.left);
                if (tmp.right != null) q.add(tmp.right);
                subList.add(tmp.data);
            }
            resultList.add(subList);
        }
        return resultList;
    }
}
