package Scal.Graph;

/* Path Exists between Nodes in Graph using BFS - Adjacency List */

import java.util.*;

public class PathExistsInGraphBFS {

    //NOTE: Graph is starting from node 1 and searching from 1 to 4

    static  boolean validPath(int n, int [][] edges, int start, int end){
        List<List<Integer>> adjacency_list = new ArrayList<>();

        //building outer list for  adjacency list
        for (int i = 0; i <= n; i++) {
            adjacency_list.add(new ArrayList<>());
        }

        // building list with each edges- - undirected graph representation
        for (int[] edge : edges) {
            adjacency_list.get(edge[0]).add(edge[1]);
            adjacency_list.get(edge[1]).add(edge[0]);
        }

        // to have level order traversal
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        // to keep track of visited nodes
        boolean visited[] = new boolean[n+1];
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // Check if we have reached the target node.
            //if (node == end) {
             //   return true;
            //}

            // Add all neighbors to the stack. - iterating inner list of list
            for (int neighbor : adjacency_list.get(node)) {
                // Check if neighbor has been added to the queue before.
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        //check whether visited array destination value is SET
        return (visited[end] )? true: false;

    }


    public static void main(String[] args) {
        int [] [] edges= {
                {1,2},
                {1,3},
                {2,3},
                {3,4},
        };
        System.out.println(validPath(4, edges, 1, 4));
    }
}
