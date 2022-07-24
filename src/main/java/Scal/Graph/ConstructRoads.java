package Scal.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Construct Roads
 * Problem Description
 * A country consist of N cities connected by N - 1 roads. King of that country want to construct maximum number of roads such that the new country formed remains bipartite country.
 * Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way, that for each road (u, v) that belongs to the country, u and v belong to different sets. Also, there should be no multiple roads between two cities and no self loops.
 * Return the maximum number of roads king can construct. Since the answer could be large return answer % 109 + 7.
 * NOTE: All cities can be visited from any city.
  */

public class ConstructRoads {
    private static  int countRoads (int A, int [][]B){

        int mod = (int)Math.pow(10,9) +7;
        List<List<Integer>> adjList = new ArrayList<>();
        int [] visited = new int [A+1];

        buildGraph(A, adjList, B, visited);
        computeUsingBFS(adjList, visited, 1);

        // separate out the two sets
        long count0 =0, count1=0;
        for (int a : visited){
            if (a == 0) count0++;
            if (a == 1 ) count1++;
        }

        // totalRoads = (x * y)
        // roads already built = n-1 (B.length)
        return (int) ((count0%mod * count1%mod) - (B.length+mod)%mod);
    }

    static void computeUsingBFS(List<List<Integer>> adjList, int[] visited, int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = 1;

        while (!que.isEmpty()) {
            int temp = que.poll();
            for (int neighbour : adjList.get(temp)) {
                if (visited[neighbour] == -1) {
                    // divide the neighboring city into opposite set
                    visited[neighbour] = 1 ^ visited[temp];
                    que.add(neighbour);
                }

            }
        }
    }

    static void buildGraph (int n , List<List<Integer>> adjList , int [][]B, int [] visited){
        for (int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
            visited[i]= -1;
        }
        // add edges
        for (int [] BB:  B){
            adjList.get(BB[0]).add(BB[1]);
            adjList.get(BB[1]).add(BB[0]);
        }
    }

    public static void main(String[] args) {
        int [][] data1 = {
                {1, 3},
                {1, 4},
                {3, 2},
                {3, 5}
        };
        System.out.println(countRoads(5, data1)); //expected 2

        int [][] data2 = {
                {1, 2},
                {1, 3}
        };
        System.out.println(countRoads(3, data2)); //expected 0
    }
}
