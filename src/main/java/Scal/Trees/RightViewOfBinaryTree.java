package Scal.Trees;

import Scal.Trees.TreeNode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/** Right view of Binary Tree
 * Problem Description
 * Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
 *
 * Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.
 */
public class RightViewOfBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {

        ArrayList<Integer> resultList = new ArrayList<>();
        //Boundary Condition
        if (A== null) return  resultList;

        //Using concept of Level order traversal with Extra prev pointer
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode prev = null;

        que.add(A) ;
        que.add(null);
        while (que.size() >1){
            TreeNode temp = que.poll();
            if (temp==null){  //level indicator
                que.add(temp);
                prev = temp;
                continue;
            }
            if (prev == null){  // if prev is null current node points to actual value
                resultList.add(temp.val);
            }
            prev = temp;
            if (temp.right != null) que.add(temp.right); // for right view
            if (temp.left !=null) que.add(temp.left);
        }
        return  resultList;
    }

}
