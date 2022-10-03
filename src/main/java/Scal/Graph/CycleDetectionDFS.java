package Scal.Graph;

import java.util.ArrayList;
import java.util.List;

/** Cycle Detection using DFS
 *  TC- O(N + 2E) + O(N)  Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes. In the case of connected components of a graph, it will take another O(N) time.
 *  SC - : O(N) + O(N) ~ O(N) Space for recursive stack space and visited array.**/
public class CycleDetectionDFS {
    private int TOTAL_NODES  = 4;
    List<List<Integer>> adjList = new ArrayList<>();

    private void buildGraph() {
        for (int i =0;i< TOTAL_NODES ;i++){
            adjList.add( new ArrayList<>());
        }
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(2);
    }

    private boolean isCyclePresent() {
        boolean [] visited = new boolean[TOTAL_NODES];
        //check for all components
        for (int i =0;i< TOTAL_NODES;i++){
            if (visited[i]== false) {
                if (dfs(visited, i,-1 )) return true;
            }
        }
        return false;
    }

    private boolean dfs(boolean[] visited, int curr, int parent) {
        visited[curr] = true;
        //traverse all adjacent nodes
        for (int neighbour : adjList.get(curr)){
            if (visited[neighbour] ==false){
                visited[neighbour] =true;
                dfs(visited, neighbour, curr);
            }
            // if neighbour node is visited and is not its own parent node
            else if (neighbour != parent) return  true;
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetectionDFS cycleDetectionDFS = new CycleDetectionDFS();
        cycleDetectionDFS.buildGraph();
        System.out.println(cycleDetectionDFS.isCyclePresent());
    }
}
