package Scal.Graph;
/*
Commutable Islands

Problem Description
There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
We need to find bridges with minimal cost such that all islands are connected.
It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.

INPUT
The first argument contains an integer, A, representing the number of islands.
The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Minimum Spanning Tree- minimum cost
public class CommutableIslandsPrimAlgo {

    static class Pair {
        int weight;
        int node;
        Pair(int weight, int node){
            this.weight = weight;
            this.node = node;
        }
    }

    //Helpful in arranging elements
    static class CustomComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.weight - o2.weight;
        }
    }

    //Using Minimum cost using PRIMS algorithm
    private static int computeMinCostUsingPrims(int A, int [][]B){

        List<List<Pair>> adjList = new ArrayList<>();
        buildGraph(adjList, A, B);
        int startingNode = 1;

        //Invoke using starting node=1
        return computeUsingPrims(adjList, A, startingNode);
    }

    //Compute minimum cost using PRIM's Algorithm
    static int computeUsingPrims(List<List<Pair>> adjList, int A, int startingNode ){
        boolean [] visited = new boolean[A+1];  // create a visited Array
        int minCost =0;

        //MIN HEAP based on weights
        PriorityQueue <Pair> pq = new PriorityQueue<>(new CustomComparator());
        //start with source node
        pq.add(new Pair(0, startingNode));

         while (!pq.isEmpty()){
             Pair min = pq.remove();

             // check if not visited
             if (!visited[min.node]){
                 //Step 1. update cost
                 minCost += min.weight;

                 //Step 2. mark as visited
                 visited[min.node] = true;

                 //Step-3: Check for adjacent elements from current node and add to Heap if not visited
                for (Pair neighbour : adjList.get(min.node)){
                     if (!visited[neighbour.node]){
                         pq.add(new Pair(neighbour.weight, neighbour.node));
                     }
                 }
             }
         }
         return minCost;
    }

    //Normal graph building mechanism
    static void buildGraph(List<List<Pair>> adjList, int A, int [][]B){
        for (int i =0;i<=A;i++){
            adjList.add(new ArrayList<>());
        }

        // since its undirected graph we need to add both edges
        for (int [] bb: B){
            adjList.get(bb[0]).add(new Pair(bb[2], bb[1]));
            adjList.get(bb[1]).add(new Pair(bb[2], bb[0]));
        }
    }

    public static void main(String[] args) {
        int [][] B = {
                {1, 2, 1},
                {2, 3, 2},
                {3, 4, 4},
                {1, 4, 3},
        };
        System.out.println(computeMinCostUsingPrims(4,B));

        int [][] BB = {
                {1, 2, 1},
                {2, 3, 4},
                {1, 4, 3},
                {4, 3, 2},
                {1, 3, 10}
        };
        System.out.println(computeMinCostUsingPrims(4,BB));
    }

}
