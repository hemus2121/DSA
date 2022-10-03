package Scal.Graph;

import java.util.*;

/**  Check Bipartite Graph - BFS
Problem Description

Given a undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there is an edge between B[i][0] and B[i][1].
Find whether the given graph is bipartite or not.
A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B

Note:
There are no self-loops in the graph.
No multiple edges between two pair of vertices.
The graph may or may not be connected.
Nodes are Numbered from 0 to A-1.
Your solution will run on multiple testcases. If you are using global variables make sure to clear them.

 TC: O(V + 2E), Where V = Vertices, 2E is for total degrees as we traverse all adjacent nodes.
 SC: O(3V) ~ O(V), Space for queue data structure, colour array and an adjacency list.
 */
public class CheckBipartiteGraphBFS {
    static boolean checkBiPartiteGraph(int A, int [][] B){
        List<List<Integer>> adjList = new ArrayList<>();

        int [] color = new int[A];
        Arrays.fill(color, -1);

        buildGraph(adjList, A, B);

        //iterate for all components present in graph
        for (int i =0;i<A;i++){
            if (color[i]== -1){
                if (!checkUsingBFS(adjList, i, color)) return false;
            }
        }
        return true;
    }

    static boolean  checkUsingBFS(List<List<Integer>> adjList, int source, int [] color){
        Queue <Integer> q=  new LinkedList<>();
        q.add( source);
        color[source] =1;
        while (!q.isEmpty()){
            int node = q.poll();
            for (int neighbour : adjList.get(node)){
                if (color[neighbour] ==-1){
                    color[neighbour] = 1- color[node];
                    q.add(neighbour);
                }
                else if (color[neighbour] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }

    static void buildGraph(List<List<Integer>> adjList , int A, int [][]B){
        for (int i =0;i<=A;i++){
            adjList.add(new ArrayList<>());
        }
        //bidirection graph
        for (int [] BB : B){
            adjList.get(BB[0]).add(BB[1]);
            adjList.get(BB[1]).add(BB[0]);
        }
    }
    public static void main(String[] args) {
        int [][] data1 = {
                {0, 2},
                {2, 0},
                {0, 3},
                {3, 0},
                {1, 3},
                {3, 1},
                {2, 3},
                {3, 2}
        };
        System.out.println(checkBiPartiteGraph(4, data1)); //expected 0
    }
}