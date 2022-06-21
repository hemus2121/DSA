package LeetCode.Graphs;

/* Graph Valid Tree - https://leetcode.com/problems/graph-valid-tree/
Problem Description
You love reading books, and you also love reading books that you've already read (weird you).
In a day, you read a total of N times, consisting of some books. Each book is represented by an index in array A.
You write the number of each book you read in the order of reading them in the array A.

You are supposed to find the book that you've least recently read (the book you haven't read for as long as possible) out of the books you've read that day (Books in array A).
 */

import java.util.*;

public class GraphValidTree {
    public static boolean validTree(int n, int[][] edges) {
        return checkValidTree(n, edges);
    }

    //Using BFS to check cycle if NO cycle is found then its valid Graph Tree
    static boolean checkValidTree(int n, int[][] edges) {
        //Very important check nodes count with edges count .. valid tree edges count = (nodes count-1)
        if (edges.length != n - 1) return false;// no of valid nodes should be (edges count -1)

        List<List<Integer>> adjList = new ArrayList<>();
        buildGraph(n, edges, adjList);

        //check for validity using BFS
         Set<Integer> visited = new HashSet<>();
        Queue<Integer> que = new LinkedList<>();
        //starting from node 0
        que.add(0);
        visited.add(0);

        while (!que.isEmpty()){
            int curr = que.poll();
            for (int neighbour : adjList.get(curr)){
                if (visited.contains(neighbour)) continue;
                visited.add(neighbour);
                que.add(neighbour);
            }
        }
        return  visited.size()==n;
    }

    private static void buildGraph(int n, int[][] edges, List<List<Integer>> adjList) {
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }

    public static void main(String[] args) {
        int n =5;
        int [] [] edges= {
                {0,1},
                {1,2},
                {2,3},
                {1,3},
                {1,4}
        };
        System.out.println(validTree(n, edges)); // expected false

        int [] [] edges1= {
                {0,1},
                {0,2},
                {0,3},
                {1,4}
        };
        System.out.println(validTree(n, edges1)); //expected true
    }
}
