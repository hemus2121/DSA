package Scal.Trees.Trees2;

/** Reverse Level Order
 * Problem Description
 * Given a binary tree, return the reverse level order traversal of its nodes values. (i.e, from left to right and from last level to starting level).
 */

import Scal.Trees.TreeNode;
import java.util.*;

public class ReverseLevelOrder {

    public ArrayList<Integer> solve(TreeNode A) {

        // Normal Level Order Traversal
        ArrayList<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        que.add(A);
        while (!que.isEmpty()){
            TreeNode temp = que.poll();
            resultList.add(temp.val);
            if (temp.right!= null) que.add( temp.right);
            if (temp.left != null) que.add(temp.left);
        }
        //Since we need from bottom reverse the result list
        Collections.reverse(resultList);
        return  resultList;
    }
}
