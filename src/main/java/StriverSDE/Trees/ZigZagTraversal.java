package StriverSDE.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Problem Statement: Given the root of a binary tree, return the zigzag level order traversal of Binary Tree.
 *  (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *  TC: SC : O(N)
 *
 */
public class ZigZagTraversal {

    public static List <List< Integer >> zigzagLevelOrder(Node root){
        List<List<Integer>> resultList = new ArrayList<>();

        boolean flag = true ; //maintain order for zipzap thing
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int levelNum = q.size();
            List<Integer> internalList = new ArrayList<>();

            for (int i =0;i< levelNum;i++) {
                Node node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

                if (flag==true)
                    internalList.add(node.data);
                else internalList.add(0, node.data);
            }
            flag = !flag; //reverse flag status for next level
            resultList.add( internalList);
        }
        return  resultList;
    }

    public static void main(String[] args) {
        int i, j;
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        List < List < Integer >> ans;
        ans = zigzagLevelOrder(root);
        System.out.println("Zig Zag Traversal of Binary Tree");
        /* expected - Zig Zag Traversal of Binary Tree
             3
             20 9
             15 7 */
        for (i = 0; i < ans.size(); i++) {
            for (j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
