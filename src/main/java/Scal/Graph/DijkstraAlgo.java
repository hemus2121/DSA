package Scal.Graph;

import java.util.*;

/*
Problem Description - Dijsktra Algo

Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
You have to find an integer array D of size A such that:
=> D[i] : Shortest distance form the C node to node i.
=> If node i is not reachable from C then -1.

Note:
There are no self-loops in the graph.
No multiple edges between two pair of vertices.
The graph may or may not be connected.
Nodes are numbered from 0 to A-1.
Your solution will run on multiple testcases. If you are using global variables make sure to clear them.

INPUT
The first argument contains an integer, A, representing the number of islands.
The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
 */
public class DijkstraAlgo {

    //class to hold weight and node info
    static class Pair {
        int weight;
        int node;
        Pair(int weight, int node){
            this.weight = weight;
            this.node = node;
        }
    }

    //helpful in arranging thing in accordance of weight
    static class customComparator implements Comparator<Pair>{
        @Override
        public int compare(Pair p1, Pair p2) {
            return p1.weight-p2.weight;
        }
    }


    private static int[] computeDijAlgo(int A, int [][]B, int C){
        List<List<Pair>> adjList = new ArrayList<>();
        buildGraph(adjList, A, B);

        // placeholder for distance array initialized to MAXIMUM value to be replaced later
        int [] dist = new int[A];
        Arrays.fill(dist, Integer.MAX_VALUE);

        computeDijistra(adjList, dist, C);

        // check if distance array has unprocessed node then convert it to -1
        for (int i=0;i< dist.length;i++){
            if (dist[i]== Integer.MAX_VALUE){
                dist[i]= -1;
            }
        }
        return  dist;
    }

    // using MINHEAP - priority Que since we need minimum value all the time
    static void computeDijistra(List<List<Pair>> adjList, int [] dist, int source){

       // since we need minimum going to use MIN-Heap - Priority Que - starting with source node
        PriorityQueue <Pair> pq = new PriorityQueue<>(new customComparator());

        // since we are starting from source let set the distance of source to ZERO
        dist[source]=0;
        pq.add( new Pair(0, source));

        //Normal BFS
        while (! pq.isEmpty()){
            Pair temp = pq.remove();
            // Go ahead with computation of options/routes if present considering minimal value of weight
            if (temp.weight == dist[temp.node]){
                // Start traversing through edges connected to current node
                for (Pair neighbour : adjList.get(temp.node)){
                    if ( dist[neighbour.node] > dist[temp.node]+ neighbour.weight){
                        dist[neighbour.node]= dist[temp.node]+ neighbour.weight;
                        pq.add(new Pair(dist[neighbour.node], neighbour.node));
                    }
                }
            }
        }
    }

    // Graph Building mechanism
    static void buildGraph(List<List<Pair>> adjList,int A, int [][]B){
        // outer structure
        for (int i =0;i<=A;i++) {
            adjList.add((new ArrayList<>()));
        }

        // Add required edges
        for (int [] BB : B){
            adjList.get(BB[0]).add(new Pair(BB[2],BB[1]));
            adjList.get(BB[1]).add(new Pair(BB[2],BB[0]));
        }
    }

    public static void main(String[] args) {
        int [][] B = {
                {0, 3, 4},
                {2, 3, 3},
                {0, 1, 9},
                {3, 4, 10},
                {1, 3, 8}
        };
        System.out.println(Arrays.toString(computeDijAlgo(5, B,4)));
    }
}
