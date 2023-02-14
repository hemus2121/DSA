package StriverSDE.Trees;

import java.util.*;

/** Vertical Order Traversal of Binary Tree
 * Problem Statement: Vertical Order Traversal Of A Binary Tree. Write a program for Vertical Order Traversal order of a Binary Tree.
 *  TC: O(N*logN)
 *  SC: O(N)
 */

public class VerticalOrderTraversal {

    //Minor modification compared to other vertical ordering code
    // Using TreeMap of <int <TreeMap <Int, Priority Queue>>
    //  --->  Inner Map is of  level -- PQ - store nodes in order
    //  ---> Outer Map is of Vertical  and which maps to level which has all nodes present at that level

    static class Tuple{
        Node node;
        int vertical;
        int level;
        Tuple (Node node, int level, int row){
            this.node = node;
            this.vertical = level;
            this.level = row;
        }
    }

    public static List <List< Integer >> findVertical(Node root) {

        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
        Queue <Tuple> q = new LinkedList ();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            Node node = tuple.node;
            int vertical = tuple.vertical;
            int level = tuple.level;

            if (!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap < > ());
            }
            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new PriorityQueue <> ());
            }
            map.get(vertical).get(level).offer(node.data);

            if (node.left != null) {
                q.offer(new Tuple(node.left, vertical - 1, level + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, vertical + 1, level + 1));
            }
        }
        List < List < Integer >> list = new ArrayList ();
        for (TreeMap < Integer, PriorityQueue <Integer>> tmap: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue <Integer> pq: tmap.values()) {
                while (!pq.isEmpty()) {
                    list.get(list.size() - 1).add(pq.poll());
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(10);

        List < List < Integer >> list = findVertical(root);

        System.out.println("The Vertical Traversal is : ");
        for (List < Integer > it: list) {
            for (int nodeVal: it) {
                System.out.print(nodeVal + " ");
            }
            System.out.println();
        }
    }
}
