package Scal.Graph;

/** Reversing Edges
 * Problem Description
 *
 * Given a directed graph with A nodes and M edges.
 * Find the minimum number of edges that needs to be reversed in order to reach node A from node 1.
 *
 * /**
 *  * Idea: add a reverse edges with cost as 1 and apply Dijkstra's shortest path
 *  * algorithm
 *  */


import java.util.*;

public class ReversingEdges {


    static List<List<Pair>> adjList = new ArrayList<>();

    //Node place holder
    static class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    //Custom comparator to give minimum weight all the time
    static class CustomComparator implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            return p1.weight- p2.weight;
        }
    }

    public static int reverseEdges(int A, int[][] B) {
        buildGraph(A, B);

        //maintain distance array
        int [] dist = new int[A+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        computeUsingDijkstraAlgo(dist, 1);
        return dist[A] == Integer.MAX_VALUE ? -1: dist[A];
    }

    //we want minimum all the time so using priorityQueue
    static void computeUsingDijkstraAlgo(int [] dist, int source){

        PriorityQueue<Pair> pq = new PriorityQueue<>(new CustomComparator());
        //start with root node
        pq.add(new Pair(source,0));
        dist[1]=0;

        while (!pq.isEmpty()){
            Pair temp =pq.remove();

            //check new distance for adjacent elements
            for (Pair neighbour : adjList.get(temp.node)){
                if (dist[neighbour.node] > dist[temp.node]+ neighbour.weight){
                    dist[neighbour.node] = dist[temp.node]+ neighbour.weight;
                    pq.add(new Pair(neighbour.node, dist[neighbour.weight]));
                }
            }
        }
    }

    static void  buildGraph(int A, int [][]B){
        for (int i =0;i<=A;i++){
            adjList.add(new ArrayList<>());
        }

        // IMP -- add edges with weight - assume weight as 0 for normal and 1 for reverse edge
        for (int []BB:B){
            adjList.get(BB[0]).add(new Pair(BB[1], 0));
            adjList.get(BB[1]).add(new Pair(BB[0], 1));
        }
    }

    public static void main(String[] args) {
       int [][] B = { {1, 2},
                {2, 3},
                {4, 3},
                {4, 5}};
     //   System.out.println(reverseEdges(5, B)); //expected 1

        int [][]   BB = { {1, 2},
                    {2, 3},
                    {3, 4},
                    {4, 5}};
        System.out.println(reverseEdges(5, BB)); //expected 0
    }
}
