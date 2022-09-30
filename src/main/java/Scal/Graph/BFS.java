package Scal.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Simple BFS Algo **/
public class BFS {

    static List<List<Integer>> adjList= new ArrayList<>();
    static int NO_OF_NODES=5;

    private static void buildGraph(){
        for (int i=0;i< NO_OF_NODES;i++){
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(0).add(4);
        adjList.get(4).add(0);
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(1).add(3);
        adjList.get(3).add(1);
    }

    private static List<Integer> bfsGraph(List<List<Integer>> adjList, int n){

        // we need Q
        List<Integer> resultList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[n];

        //add initial value to q
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()){
            Integer node = q.poll();
            resultList.add(node);

            for (int neighbour : adjList.get(node)){
                if (!visited[neighbour]){
                    visited[neighbour] =true;
                    q.add(neighbour);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        buildGraph();
        //bfs traversal
        List<Integer> result = bfsGraph (adjList, NO_OF_NODES);
        for (int i : result){
            System.out.println(i +" ");  //expected 0 1 4 2 3s
        }
    }
}
