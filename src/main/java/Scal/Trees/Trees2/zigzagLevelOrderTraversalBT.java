package Scal.Trees.Trees2;
/** ZigZag Level Order Traversal BT
 * Problem Description
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 */

import Scal.Trees.TreeNode;

import java.util.*;

public class zigzagLevelOrderTraversalBT {
    static public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

        //Level order traversal  with making level nodes in opposite order
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        boolean level = true;

        que.add(A);
        que.add(null);

        while (que.size()>1){
            TreeNode temp = que.poll();
            //if level is reached
            if (temp ==null){
                if (level){
                    level =false;
                }else {   // if order is changes reverse tempList
                    Collections.reverse(tempList);
                    level =true;
                }
                resultList.add(new ArrayList<>(tempList));
                que.add(null);
                tempList = new ArrayList<>();
                continue;
            }

            tempList.add(temp.val);

            //traverse left and right subtrees
            if (temp.left !=null) que.add(temp.left);
            if (temp.right != null) que.add(temp.right);
        }

        if (!level) Collections.reverse(tempList);
        resultList.add(new ArrayList<>(tempList));
        return  resultList;
    }
  }
