package Scal.Graph;

import java.util.*;

/** Topological Sort - DFS
 * Problem Description - https://bit.ly/3PvBfsm
 * Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 * Return the topological ordering of the graph and if it doesn't exist then return an empty array.
 * If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.
 * Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.
 *
 * The first argument given is an integer A representing the number of nodes in the graph.
 *
 * The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 */
public class TopologicalSortDFS {

    //Method of building Graph along with collecting Indegree for each node
    private static void buildGraph(int A, int [][]B, List<List<Integer>> adjList){
        for(int i =0;i<=A;i++){
            adjList.add(new ArrayList<>());
        }
        for (int [] BB: B){
            adjList.get(BB[0]).add(BB[1]);
        }
    }

    private static void dfs(int i, List<List<Integer>> adjList, int[] visited, Stack<Integer> st) {
        visited[i]= 1;
        for( int neighbour : adjList.get(i)){
            if (visited[neighbour]==0){
                dfs(neighbour, adjList, visited,st);
            }
        }
        st.push( i);
    }

    static public int [] topoSort(int V, int [][]B){

        List<List<Integer>> adjList = new ArrayList<>();
        buildGraph(V, B, adjList);

        // we need stack to hold elements visited
        int [] visited=  new int [V];
        Stack <Integer> st = new Stack<>();
        //iterate for all given elements
        for (int i =0;i< V;i++){
            if (visited[i]==0){
                dfs(i, adjList, visited, st);
            }
        }

        //poping from stack elements
        int [] ans = new int [V];
        int i =0;
        while (!st.isEmpty()){
            ans [i++] = st.pop();
        }
        return ans ;
    }

    public static void main(String[] args) {
        int A = 6;
        int [][] B = {  {6, 3},
                {6, 1},
                {5, 1},
                {5, 2},
                {3, 4},
                {4, 2 } };
        System.out.println(Arrays.toString(topoSort(A, B)));
    }
}
