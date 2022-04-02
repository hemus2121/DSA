package Scal.Graph;

import java.util.*;

/*
 BFS using Arraylist implement for Adjacency list- NOT USED much
 */

public class SimpleBFSUsingArrayList {
    static void simpleBFS(int n, int [][] edges, int start){

        //construct Graph to hold list values
        List<List<Integer>> adjacency_list = new ArrayList<>();
        for (int i=0;i<= n;i++){
            adjacency_list.add(new ArrayList<>());
        }

        //insert edges
        for (int [] edge: edges){
            adjacency_list.get(edge[0]).add(edge[1]);
            adjacency_list.get(edge[1]).add(edge[0]);
        }

        // BFS Search
        boolean [] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        // to keep track of visited nodes
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node+ " " );

            // Add all neighbors to the stack. - iterating inner list of list
            for (int neighbor : adjacency_list.get(node)) {
                // Check if neighbor has been added to the queue before.
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
    public static void main(String[] args) {
        int [] [] edges= {
                {1,2},
                {1,3},
                //{2,3},
                {3,1},
                {3,4},
                {4,4}
        };
        simpleBFS(4, edges, 3);
    }
}
