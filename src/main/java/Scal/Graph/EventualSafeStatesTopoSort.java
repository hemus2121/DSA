package Scal.Graph;

import java.util.*;

/** Eventual Safe Nodes - https://bit.ly/3C90n59
 * A directed graph of V vertices and E edges is given in the form of an adjacency list adj. Each node of the graph is labelled with a distinct integer in the range 0 to V - 1.
 * A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node.
 * You have to return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 *
 * TC- O(N + 2E) + O(N)  Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes. In the case of connected components of a graph, it will take another O(N) time.
 * SC - : O(N) + O(N) ~ O(N) Space for recursive stack space and visited array.
 **/

public class EventualSafeStatesTopoSort {

    // Main logic - Reverse EDGES given to get terminal nodes since they will have indegree count =0
    private void buildGraph(int N,List<List<Integer>> adjList, int [] indegree,List<List<Integer>> adjRev ){
        for (int i=0;i< N;i++){
            adjRev.add(new ArrayList<>());
        }

        for (int i =0;i< N;i++){
            for (int it : adjList.get(i)){
                adjRev.get(it).add(i); // adding edge in reverse order of GIVEN direction
                indegree[i]=0;
            }
        }
    }


    private List <Integer> eventualSafeNodes (int N, List<List<Integer>>adjList){
        int [] indegreee = new int [N];
        List<List<Integer>>adjRev =null;
        buildGraph (N, adjList, indegreee, adjRev);

        Queue <Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i =0;i< indegreee.length;i++){
            if (indegreee[i]==0){
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            int node = q.poll();
            safeNodes.add(node);
            for ( int neighbour : adjRev.get(node)){
                indegreee[neighbour]--;
                if (indegreee[neighbour]==0)q.add(neighbour);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

    public static void main(String[] args) {

    }

}
