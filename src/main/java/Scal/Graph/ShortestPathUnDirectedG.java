package Scal.Graph;

import java.util.*;

/**  Shortest path in Undirected Graph having unit distance  https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
 * You are given an Undirected Graph having unit weight, Find the shortest path from src(0) to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.
 */
public class ShortestPathUnDirectedG {

    private void buildGraph(List<List<Integer>> adjList , int[][] edges, int n, int m) {
        for (int i =0;i< n;i ++){
            adjList.add(new ArrayList<>());
        }

        for (int i =0;i< m;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
    }
     public int[]  shortestPath (int [][] edges, int n, int m, int src){
         List<List<Integer>> adjList = new ArrayList<>();
         buildGraph(adjList, edges,n, m);

         int [] dist = new int[n];
         Arrays.fill(dist, Integer.MAX_VALUE);

         // set for source
         dist[src]=0;

         // using BFS
         Queue <Integer> q = new LinkedList<>();
         q.add(src);
         while (!q.isEmpty()){
             int node = q.poll();

             for (int neighbour: adjList.get(node)){
                 if (dist[node]+ 1 < dist[neighbour]){
                     dist[neighbour] = dist[node]+1;
                     q.add(neighbour);
                 }
             }
         }

         for (int i=0;i< n;i++){
             if (dist[i]== Integer.MAX_VALUE){
                 dist[i]=-1;
             }
         }
         return  dist;
     }

    public static void main(String[] args) {

    }
}
