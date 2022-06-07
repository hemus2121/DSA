package Scal.Trees.Trees2;
/** Vertical Order Traversal
 * Problem Description
 *
 * Given a binary tree, return a 2-D array with vertical order traversal of it.
 * Go through the example and image for more details.
 * NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
 */

import Scal.Trees.TreeNode;
import java.util.*;

public class VerticalOrderTraversal {

    //Global variables
    static Map<Integer, ArrayList<Integer>> levelMap = new HashMap<>();
    static int maxl=0;
    static int minl=0;

    //Template class to hold treeNode along with level
   static class Pair{
        TreeNode treeNode;
        int level;
        //Constrctor
        Pair(TreeNode treeNode, int level){
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    static public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        return verticalTraversal(A);
    }
    static ArrayList<ArrayList<Integer>> verticalTraversal (TreeNode A){
        //Level order traversal - increase level on right , decrease level on left
        Queue <Pair> que =new LinkedList<>();
        Pair rootPair = new Pair(A, 0);
        que.add(rootPair);

        //Iterate Que
        while (!que.isEmpty()){
            Pair tPair = que.remove();
            TreeNode tNode = tPair.treeNode;
            int level = tPair.level;

            //update max/min levels
            maxl = Math.max(maxl, level);
            minl = Math.min(minl, level);

            //Step1 Update level map
            if (levelMap.containsKey(level)){
                //upate level entry in map
                ArrayList<Integer> tempList = levelMap.get(level);
                tempList.add(tNode.val);
                levelMap.put(level, tempList);
            }else {
                //add new level entry in map
                ArrayList <Integer> tempList = new ArrayList<>();
                tempList.add(tNode.val);
                levelMap.put(level, tempList);
            }

            //Step2 :Add left side nodes
            if (tNode.left!=null){
                Pair lPair = new Pair(tNode.left, level-1);
                que.add(lPair);
            }

            //Step3: Add right side nodes
            if (tNode.right !=null){
                Pair rPair = new Pair(tNode.right, level+1);
                que.add(rPair);
            }
        }

        //Step 4: Traverse map from min to max level keys
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        for (int i = minl;i<= maxl;i++){
            resultList.add(new ArrayList<>(levelMap.get(i)));
        }
        return resultList;
    }
}
