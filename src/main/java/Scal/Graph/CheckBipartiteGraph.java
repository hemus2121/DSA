package Scal.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Check Bipartite Graph
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
 */
public class CheckBipartiteGraph {
    static int checkBiPartiteGraph(int A, int [][] B){
        List<List<Integer>> adjList = new ArrayList<>();

        int [] color = new int[A];
        Arrays.fill(color, -1);

        constructGraph(adjList, A, B);
        //iterate for all components present in graph
        for (int i =0;i<A;i++){
            if (color[i]== -1){
                //set initial value
                color[i] = 1;
                if (!checkUsingDFS(adjList, i, color)) return 0;
            }
        }
        return 1;
    }

    static boolean  checkUsingDFS(List<List<Integer>> adjList, int source, int [] color){

        for (int neighbour : adjList.get(source)){
            //check if neighbour is not colored yet
            if (color[neighbour] == -1){
                color[neighbour] = color[source] ^1;
                if (!checkUsingDFS(adjList, neighbour, color)){
                    return  false;
                }
            }
            // check if neighbour and current is coloured SAME
            if (color[neighbour]== color[source]){
                return  false;
            }
        }
        return  true;
    }

    static void constructGraph(List<List<Integer>> adjList , int A, int [][]B){
        for (int i =0;i< A;i++){
            adjList.add(new ArrayList<>());
        }
        //bidirection graph
        for (int [] BB : B){
            adjList.get(BB[0]).add(BB[1]);
            adjList.get(BB[1]).add(BB[0]);
        }
    }
    public static void main(String[] args) {
        //A : 9
        //B :
        //[
        //  [2, 5]
        //  [6, 7]
        //  [4, 8]
        //  [2, 3]
        //  [0, 3]
        //  [4, 7]
        //  [1, 8]
        //  [3, 8]
        //  [1, 3]
        //]
        int [] [] data = {
                {0, 1}
        };
       // System.out.println(checkBiPartiteGraph(2, data));

        int [][] data1 = {
                {0, 1},
                {0, 2},
                {1, 2}
        };
        System.out.println(checkBiPartiteGraph(3, data1));
    }
}
