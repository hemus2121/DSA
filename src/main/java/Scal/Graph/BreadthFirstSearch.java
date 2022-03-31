package Scal.Graph;

/* Sample program for BFS using Adjacency Matrix */
import java.util.*;

public class BreadthFirstSearch {
    static  boolean validPath(int n, int [][] edges, int start, int end){
        List<List<Integer>> adjacency_list = new ArrayList<>();

        //building outer list for  adjacency list
        for (int i = 0; i < n; i++) {
            adjacency_list.add(new ArrayList<>());
        }

        // building list with each edges
        for (int[] edge : edges) {
            adjacency_list.get(edge[0]).add(edge[1]);
            adjacency_list.get(edge[1]).add(edge[0]);
        }

        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);
        visited[start] = true;

        while (!queue.isEmpty()) {
            // Get the current node.
            int node = queue.poll();

            // Check if we have reached the target node.
            if (node == end) {
                return true;
            }

            // Add all neighbors to the stack.
            for (int neighbor : adjacency_list.get(node)) {
                // Check if neighbor has been added to the queue before.
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int [] [] edges= {
                {0,1},
                {0,2},
                {1,2},
                {2,0},
                {2,3},
                {3,3}
        };
        System.out.println(validPath(4, edges, 0, 3));
    }
}
