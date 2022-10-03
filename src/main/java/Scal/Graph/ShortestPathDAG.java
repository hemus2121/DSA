package Scal.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/** Shortest Path in Directed Acyclic Graph - https://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/
 *  Given a Weighted Directed Acyclic Graph and a source vertex in the graph, find the shortest paths from given source to all other vertices.
 * TC: O(N+M)
 */

public class ShortestPathDAG {

    static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private void topoSort(int node,  List<List<Pair>> adjList , int [] vis, Stack st ){
        vis[node]=1;
        for (int i=0; i<adjList.get(node).size();i++){
            int v = adjList.get(node).get(i).node;
            if (vis[v]==0){
                topoSort(v, adjList, vis, st);
            }
        }
        st.push(node);
    }

    private void buildGraph(int N, int M, int[][] edges, List<List<Pair>> adjList) {
        for (int i =0;i< N;i++){
            adjList.add(new ArrayList<>());
        }

        //iterate edges and build adjList
        for (int i=0;i<M;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adjList.get(u).add(new Pair(v, wt));
        }
    }

    public int [] shortestPath (int N, int M , int [][] edges){
        List<List<Pair>> adjList = new ArrayList<>();
        buildGraph(N, M, edges, adjList);

        // Step1 :invoke TOPO sort
        int [] visited = new int [N];
        Stack<Integer> st = new Stack<>();
        for (int i =0;i< N;i++){
            if (visited[i]==0){
                topoSort(i, adjList, visited, st);
            }
        }

        // Step 2: distance array initalised with infinity
        int [] dist = new int[N];
        Arrays.fill(dist, (int)(1e9));

        //Iterate stack and update distance
        dist[0]=0;
        while (!st.isEmpty()){
            int node = st.pop();
            for (int neighbour =0;neighbour< adjList.get(node).size();neighbour++){
                //get  node
                int v = adjList.get(node).get(neighbour).node;
                int wt = adjList.get(node).get(neighbour).weight;

                if (dist[node]+ wt < dist[v]){
                    dist[v] = dist[node]+ wt;
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {

    }
}
