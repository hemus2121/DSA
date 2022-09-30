package Scal.Graph;

import java.util.ArrayList;
import java.util.List;

/** No of Provinces
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 */
public class NoOfProvinces {

    static List <List<Integer>> adjList = new ArrayList<>();
    final static int LENGTH =3;

    private static void buildGraph(List<List<Integer>> adjMatrix ){
        for(int i =0;i< LENGTH;i++){
            adjList.add( new ArrayList<>());
        }
        for (int i =0;i< LENGTH;i++){
            for (int j =0;j< LENGTH;j++){
                if (adjMatrix.get(i).get(j)==1 && i != j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
    }

    private static void dfs(int node , List<List<Integer>> adjList, int [] visited){
        visited[node]=1;
        for(int neighbour : adjList.get(node)){
            if (visited[neighbour]==0){
                dfs(neighbour, adjList, visited);
            }
        }
    }

    private static int computeComponents(List<List<Integer>> adjList){
        int [] visited  = new int[LENGTH];
        int cnt =0;
        for (int i =0;i<LENGTH;i++){
            if (visited[i]==0){
                cnt++;
                dfs(i, adjList, visited);
            }
        }
        return  cnt;
    }

    public static void main(String[] args) {
        // adj matrix init
        List<List<Integer>> adjMatrix = new ArrayList<>();

        adjMatrix.add(new ArrayList<Integer>());
        adjMatrix.get(0).add(0, 1);
        adjMatrix.get(0).add(1, 0);
        adjMatrix.get(0).add(2, 1);
        adjMatrix.add(new ArrayList<Integer>());
        adjMatrix.get(1).add(0, 0);
        adjMatrix.get(1).add(1, 1);
        adjMatrix.get(1).add(2, 0);
        adjMatrix.add(new ArrayList<Integer>());
        adjMatrix.get(2).add(0, 1);
        adjMatrix.get(2).add(1, 0);
        adjMatrix.get(2).add(2, 1);

        buildGraph(adjMatrix);
        System.out.println(computeComponents(adjList)); //expected 2
    }
}
