package Scal.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


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
       // System.out.println(countRoads(5, data1));

        int [][] data2 = {
                {2, 1}
        };
        System.out.println(countRoads(2, data2));

    }
}
