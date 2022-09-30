package Scal.Trees;

/** Level Order
Problem Description
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
import Scal.Trees.TreeNode;
import java.util.*;

public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrderTraversal(TreeNode A) {

        //Boundary Condition
        if (A==null ) return null;

        ArrayList<ArrayList<Integer>> resList = new ArrayList();
        ArrayList<Integer> levelList = new ArrayList();

        // We need to use que to do level order traversing
        Queue <TreeNode> que = new LinkedList<>();

        //Add root element to Q
        que.add(A);
        que.add(null); //maker for each level for levels

        while (que.size()>1){
            TreeNode temp = que.remove();

            //case: temp value is null
            if (temp==null){
                //add the previous value present in level
                resList.add(new ArrayList<>(levelList));
                que.add(null);
                levelList = new ArrayList<>();
                continue;
            }

            //case: where temp is has value correct  add to output
            levelList.add(temp.val);

            if (temp.left!=null) que.add(temp.left);
            if (temp.right!=null) que.add(temp.right);
        }
        //if any data is present in level still
        if (levelList !=null){
            resList.add(new ArrayList<>(levelList));
        }
        return  resList;
    }
}
