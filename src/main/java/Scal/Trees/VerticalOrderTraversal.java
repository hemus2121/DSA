package Scal.Trees;


import java.util.*;
/*
Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.

 */

public class VerticalOrderTraversal {

    static class Pair {
        TreeNode treeNode;
        Integer level;

        //Constructor
        Pair(TreeNode treeNode, Integer level){
            this.treeNode = treeNode;
            this.level = level;
        }
    }
    private static List<ArrayList<Integer>> verticalOrder(TreeNode A){
        return computeVerticalOrder(A);
    }

    static Map<Integer, ArrayList<Integer>> levelMap = new HashMap<>();
    static Queue <Pair> que = new LinkedList<>();
    static int maxl=0, minl=0;

    private static List<ArrayList<Integer>>computeVerticalOrder(TreeNode A){
        Pair pair = new Pair(A, 0);
        que.add(pair);

        //iterate until Que is empty
        while (!que.isEmpty()){
            Pair tempPair = que.remove();
            TreeNode tempNode = tempPair.treeNode;
            int level = tempPair.level;

            //update max and min levels
            maxl = Math.max(maxl, level);
            minl = Math.min(minl, level);

            //Step 1:Insert into HashMap - if preset update else add new list
            if (levelMap.containsKey(level)){
                ArrayList<Integer> tempList = levelMap.get(level);
                tempList.add(tempNode.val);
                levelMap.put(level, tempList);
            }else {
                ArrayList <Integer> tempList = new ArrayList();
                tempList.add(tempNode.val);
                levelMap.put(level, tempList);
            }

            // Step 2: Add left child into Q - since traversing to left from root
            if (tempNode.left!=null){
                Pair leftPair = new Pair(tempNode.left, -1);
                que.add(leftPair);
            }

            // Step 3: Add right child into Q -- +1 since traversing to right
            if (tempNode.right != null){
                Pair rightPair = new Pair(tempNode.right, +1);
                que.add(rightPair);
            }
        }

        List<ArrayList<Integer>> res = new ArrayList<>();
        //Iterate map index minl to maxl and add to response list
        for (int i = minl;i<=maxl;i++){
            res.add(levelMap.get(i));
        }
        return res;
    }

}
