package Scal.Graph;

import java.util.ArrayList;
import java.util.List;

/** Eventual Safe Nodes - https://bit.ly/3C90n59
 * A directed graph of V vertices and E edges is given in the form of an adjacency list adj. Each node of the graph is labelled with a distinct integer in the range 0 to V - 1.
 * A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node.
 * You have to return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 *
 * TC- O(N + 2E) + O(N)  Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes. In the case of connected components of a graph, it will take another O(N) time.
 * SC - : O(N) + O(N) ~ O(N) Space for recursive stack space and visited array.
 **/

public class EventualSafeStates {

    private boolean dfs(int i, List<List<Integer>>adjList, int [] vis, int [] pathVisited, int [] check){
        vis[i] =1;
        pathVisited[i] =1;
        check[i]=1;

        //traverse for adj nodes
        for (int neighbour : adjList.get(i)){
            //when node is not visited
            if (vis[neighbour]==0){
                if (dfs(neighbour, adjList, vis, pathVisited, check)){
                    return true;
                }
            } else if (pathVisited[neighbour]==1){
                return true;
            }
        }
        check[i]=1;
        pathVisited[i]=0;
        return  false;
    }

    private List <Integer> eventualSafeNodes (int N, List<List<Integer>>adjList){
        int [] vis = new int [ N];
        int [] pathVisited = new int [N];
        int [] check  = new int [N]; // to mark safe nodes

        //iterate for all connected components
        for (int i=0;i< N;i++){
            if (vis[i]==0){
                dfs(i, adjList, vis,pathVisited, check);
            }
        }

        List <Integer> safeNodes = new ArrayList<>();
        for (int i =0;i<N;i++){
            if (check[i]==1) safeNodes.add(i);
        }
        return safeNodes;
    }

    public static void main(String[] args) {

    }

}
