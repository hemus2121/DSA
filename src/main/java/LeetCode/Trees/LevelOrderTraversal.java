package LeetCode.Trees;
/** Binary Tree level order traversal  -https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */

import Blind75.Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(Blind75.Trees.TreeNode root) {

        Queue <Blind75.Trees.TreeNode> que = new LinkedList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        //corner case
        if (root == null ) return resultList;

        que.add(root);
        que.add(null);

        while(que.size()>1){
            TreeNode temp = que.poll();
            // we got level indicator
            if (temp ==null){
                // we need to add result to final list
                resultList.add(tempList);
                //reset for new incoming element
                tempList = new ArrayList<>();
                que.add(null);
                continue;
            }
            tempList.add(temp.val);

            if (temp.left!=null) que.add(temp.left);
            if (temp.right != null) que.add(temp.right);
        }
        if (tempList !=null) resultList.add(tempList);
        return resultList;
    }
}
