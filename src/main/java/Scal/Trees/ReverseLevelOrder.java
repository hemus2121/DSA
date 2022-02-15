package Scal.Trees;
/*
Problem Description

Given a binary tree, return the reverse level order traversal of its nodes values. (i.e, from left to right and from last level to starting level).
*/

import java.util.*;

public class ReverseLevelOrder {

    private ArrayList<Integer> reverseLevelOrder(TreeNode A){
        if (A== null) return null;
        ArrayList<Integer> tempList = new ArrayList<>();
        Queue <TreeNode> que = new LinkedList<>();
        que.add(A);

        while (!que.isEmpty()){
            TreeNode temp= que.remove();
            tempList.add(temp.val);
            if (temp.right != null) que.add(temp.right);
            if(temp.left != null) que.add(temp.left);

        }
         ArrayList<Integer> resList = new ArrayList<>();
        for (int i = tempList.size()-1;i>=0;i--){
            resList.add ( tempList.get(i));
        }
        return  resList;
    }

}
