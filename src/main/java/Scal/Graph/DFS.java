package Scal.Graph;

import java.util.ArrayList;
import java.util.List;

/** Simple DFS Algo- Recursive  **/
public class DFS {
    static List<List<Integer>> adjList= new ArrayList<>();
    static int NO_OF_NODES=5;

    private static void  buildGraph(){
        for (int i =0; i< NO_OF_NODES;i++){
             adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(2);
        adjList.get(2).add(0);
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(0).add(3);
        adjList.get(3).add(0);
        adjList.get(2).add(4);
        adjList.get(4).add(2);
    }

    private static void dfs(int node, List<List<Integer>> adjList, boolean[] visited,List<Integer> resultList){
        //marking current node visited
        visited[node]= true;
        resultList.add(node);

        for (Integer neighbour : adjList.get(node)){
            if (visited[neighbour]== false){
                dfs(neighbour, adjList, visited, resultList);
            }
        }
    }

    private static List<Integer> dfsGraph(List<List<Integer>> adjList, int n){
        boolean [] visited = new boolean [n+1];
        visited[0] = true;
        List <Integer> resultList = new ArrayList<>();
        dfs(0,adjList, visited, resultList);
        return resultList;

    }
    public static void main(String[] args) {
        buildGraph();
        //bfs traversal
        List<Integer> result = dfsGraph (adjList, NO_OF_NODES);
        for (int i : result){
            System.out.println(i +" ");  //expected 0 2 4 1 3
        }
    }
}
