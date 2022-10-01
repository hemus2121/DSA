package Scal.Graph;

/** Cycle Detection using BFS using parent node concept
 * TC - O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes. In the case of connected components of a graph, it will take another O(N) time.
 * SC -  O(N) + O(N) ~ O(N), Space for queue data structure and visited array. **/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class CycleDetectionBFS {

    private int TOTAL_NODES  = 4;
    List<List<Integer>> adjList = new ArrayList<>();

    class Pair {
        int current, parent;
        Pair (int current, int previous){
            this.current = current;
            this.parent = previous;
        }
    }

    private void buildGraph() {
        for (int i =0;i< TOTAL_NODES ;i++){
            adjList.add( new ArrayList<>());
        }
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(2);
    }

    boolean checkCycle (int src, boolean[] visited){

        visited [src] = true;
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));

        while (!q.isEmpty()){
            Pair pair = q.poll();
            int node = pair.current;
            int parent = pair.parent;

            //iterate adj nodes of current node
            for (int neighbour : adjList.get(node)){
                if (visited[neighbour]== false){
                    visited[neighbour] =true;
                    q.add(new Pair(neighbour,node));
                } else{
                    // if adjacent node is visited and is not its own parent node
                    if (parent !=neighbour) return true;
                }
            }
        }
        return false;
    }
    private boolean isCyclePresent() {
        //create boolean array
        boolean [] visited = new boolean[TOTAL_NODES];

        //check for all nodes present in graphs - checking for all connected components
        for (int i =0;i< TOTAL_NODES; i++){
            if (visited[i]==false){
                if (checkCycle(i, visited )) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetectionBFS cdbfs = new CycleDetectionBFS();
        cdbfs.buildGraph();
        System.out.println(cdbfs.isCyclePresent()); //expected false or zero
    }
}