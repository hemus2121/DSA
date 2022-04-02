package Scal.Graph;

/*
 Path in Directed Graph

Problem Description
Given a directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node
B[i][0] to node B[i][1].
Find whether a path exists from node 1 to node A.
Return 1 if path exists else return 0.

 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathDirectedGraphBFS {
    private static int checkPathInDirectedGraph(int A, int [][] B){

        // construct Adjacency List
        List<List<Integer>> adjList= new ArrayList<>();
        for (int i=0;i<=A;i++){
            adjList.add(new ArrayList<>());
        }

        //construct edges given - directed graph mentioned
        for (int [] edge : B){
            adjList.get(edge[0]).add(edge[1]);
        }

        return checkPath(A, 1, A, adjList);
    }

    // TRAVERSAL - using Queue - for level order traversal
    private static int checkPath(int A, int start, int dest, List<List<Integer>> adjList) {

        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[A +1]; //track visited nodes

        queue.add(start);
        visited[start] =true;

        while (!queue.isEmpty()){
            int node = queue.poll();

            if (node == dest) return 1;

            ///check neighbours of current node
            for (int neighbour : adjList.get(node)){
                // it not visited yet - visit it
                if (!visited[neighbour]){
                    visited[neighbour]=true;
                    queue.add(neighbour);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
            int [][] B ={
                  /*  {1, 2},
                    {4, 1},
                    {2, 4},
                    {3, 4},
                    {5, 2},
                    {1, 3} */
                    {1, 2},
                    {2, 3},
                    {3, 4},
                    {4, 5}
            };
            int countOfNodes=5;
        System.out.println(checkPathInDirectedGraph(countOfNodes,B));
    }
}
