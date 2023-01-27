package Scal.Graph;

import java.util.*;

/** Toplogical Sort - Using BFS
 * Problem Description
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
public class TopologicalSort {

    static public int [] topoSort(int A, int [][]B){

        List<List<Integer>> adjList = new ArrayList<>();

        // we need array to hold INDEGREE count for each node init with MAX value
        int [] indegree = new int [A+1];
        buildGraph(A, B, adjList, indegree);

        List<Integer> resultList = new ArrayList<>();
        topoSortData(A, indegree,adjList, resultList);

        return resultList.stream().mapToInt(val -> val).toArray();
    }

    //Topological sort Method using BFS
    private static void topoSortData(int n, int [] indegree,  List<List<Integer>> adjList,List<Integer> resultList){
        Queue<Integer> que = new LinkedList<>();

        //Add nodes which have indegree ==0
        for (int i =1;i< indegree.length;i++){
            if (indegree[i]==0){
                que.add(i);
            }
        }

        //Normal BFS process using Que
        while (!que.isEmpty()){
            int temp = que.poll();
            resultList.add(temp); // add to result List indegree =0 nodes as we are taking out from Q

            for (int neighbour : adjList.get(temp)){
                indegree[neighbour]--; // reduce indegree of destination nodes
                if (indegree[neighbour] ==0){ // add ot que if indegree reached ZERO
                    que.add(neighbour);
                }
            }
        }
    }

    //Method of building Graph along with collecting Indegree for each node
    private static void buildGraph(int A, int [][]B, List<List<Integer>> adjList, int [] indegree){
        for(int i =0;i<=A;i++){
            adjList.add(new ArrayList<>());
        }

        for (int [] BB: B){
            adjList.get(BB[0]).add(BB[1]);
            indegree[BB[1]]++;
        }
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
