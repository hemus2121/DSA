package Scal.Graph;

/** Cycle in Directed Graph
 Problem Description
 Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
 */

 import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleInDirectedGraph {


    public static  int checkCycleInDirectedGraph(int A, int [][]B){
        List<List<Integer>> adjList = new ArrayList<>();
        // build in-degree array and adjacency list
        int [] indegree = new int [A+1];
        buildGraph(A, B, adjList, indegree);

        return isCyclePresent(A, indegree, adjList);
    }

    // We shall be using BFS traversal to identify count and  check against total nodes
    static int isCyclePresent(int A, int [] indegree,List<List<Integer>>adjList){
        Queue <Integer> queue= new LinkedList<>();

        //to start with add node with indegree of zero to Q
        for (int i =1;i< indegree.length;i++){
            if (indegree[i]==0){
                queue.add(i);
            }
        }

        int cnt =0; // count of nodes visited
        // for each node, visit all it's neighbors and decrease inDegree and insert into  queue
        while (!queue.isEmpty()){
            int temp = queue.poll();
            cnt++;
            //traverse adj list of current node
            for (int neighbour : adjList.get(temp)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        // at the end, if count  == no of nodes present then No cycle is present else cycle is present
        if(cnt == A) return 0;
        return 1;
    }

    static  void buildGraph(int A, int [][]B, List<List<Integer>> adjList, int [] indegree){
        for (int i =0;i<=A;i++){
            adjList.add(new ArrayList<>());
        }
        //adding edges and building indegreue array
        for (int [] BB : B){
            adjList.get(BB[0]).add(BB[1]);
            indegree[BB[1]]++;
        }
    }

    public static void main(String[] args) {
      int [][] B= {
                {1, 2},
                {4, 1},
                {2, 4},
                {3, 4},
                {5, 2},
                {1,3}
        };
        System.out.println(checkCycleInDirectedGraph(5, B)); //expected =1
    }
}
