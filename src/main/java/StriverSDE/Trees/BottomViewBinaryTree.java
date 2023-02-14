package StriverSDE.Trees;

import java.util.*;

/** Bottom View of Binary Tree
 * Problem Statement: Given below is a binary tree.
 * The task is to print the bottom view of  binary tree. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top
 * TC: SC : O( N)
 */
public class BottomViewBinaryTree {
    static class Pair {
        Node node;
        int level;

        Pair (Node node, int level){
            this.node = node;
            this.level = level;
        }
    }

    // Using Level order traversal technique
    public static List<Integer> bottomView (Node root){

        List <Integer> resultList = new ArrayList<>();
        Map <Integer, Integer> nodeMap= new TreeMap<>() ;// value type is just 1 value rather than list
        if (null == root) return  resultList;

        // We need Q Ds to have level order traversal flow
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root , 0));

        while (!q.isEmpty()){
            Pair tempPair = q.poll();
            Node tempNode = tempPair.node;
            int level = tempPair.level;

            // update with latest value in map so that we get bottom view of TREE - NO check whether element is present is required
            nodeMap.put(level, tempNode.data);

            if (tempNode.left != null){
                q.add(new Pair(tempNode.left, -1));
            }

            if (tempNode.right != null){
                q.add(new Pair(tempNode.left, +1));
            }
        }

        //iterate and store map values since it contains only 1 values
        for (Map.Entry<Integer, Integer> entry: nodeMap.entrySet()){
            resultList.add (entry.getValue());
        }

        return resultList;
    }
}
