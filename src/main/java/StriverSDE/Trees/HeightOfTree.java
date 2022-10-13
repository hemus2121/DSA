package StriverSDE.Trees;

import java.util.LinkedList;
import java.util.Queue;

/** Maximum Depth of Binary Tree
 *  Find the Maximum Depth of Binary Tree. Maximum Depth is the count of nodes of the longest path from the root node to the leaf node.
 *  TC: SC:O (N)
 */
public class HeightOfTree {

    //recursive solution
    public int getHeight(Node node){
        if (node ==null) return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left, right)+1; //for current node
    }

    // using Iterative Way
    public static int levelOrder(Node root){
        if (root==null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level =0;
        while (q.size() >0) {
            int size = q.size();
            while (size > 0) {
                Node node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level++;
        }
        return level;
    }

}
