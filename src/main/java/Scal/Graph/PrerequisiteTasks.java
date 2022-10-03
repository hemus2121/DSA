package Scal.Graph;

import java.util.*;


/** Prerequisite Tasks - https://bit.ly/3ApDfOm , https://bit.ly/3SYjQvp
 * There are a total of N tasks, labeled from 0 to N-1. Some tasks may have prerequisites, for example to do task 0 you have to first complete task 1, which is expressed as a pair: [0, 1]
 * Given the total number of tasks N and a list of prerequisite pairs P, find if it is possible to finish all tasks.
 *
 */
public class PrerequisiteTasks {
    //Method of building Graph along with collecting Indegree for each node
    static public String topoSort(int A, int [][]B){

        List<List<Integer>> adjList = new ArrayList<>();

        // we need array to hold INDEGREE count for each node init with MAX value
        int [] indegree = new int [A+1];
        buildGraph(A, B, adjList, indegree);

        List<Integer> resultList = new ArrayList<>();
        return (topoSortData(A, indegree, adjList, resultList) == A) ? "YES" :"NO";
        //return resultList.stream().mapToInt(val -> val).toArray();
    }

    //Topological sort Method using BFS
    private static int topoSortData(int n, int [] indegree,  List<List<Integer>> adjList,List<Integer> resultList){
        Queue<Integer> que = new LinkedList<>();

        //Add nodes which have indegree ==0
        for (int i =1;i< indegree.length;i++){
            if (indegree[i]==0){
                que.add(i);
            }
        }

        int count=0;
        //Normal BFS process using Que
        while (!que.isEmpty()){
            int temp = que.poll();
            resultList.add(temp);// add to result List indegree =0 nodes as we are taking out from Q
            count++;

            for (int neighbour : adjList.get(temp)){
                indegree[neighbour]--; // reduce indegree of destination nodes
                if (indegree[neighbour] ==0){ // add ot que if indegree reached ZERO
                    que.add(neighbour);
                }
            }
        }
        return count;
    }

    //Method of building Graph along with collecting Indegree for each node
    private static void buildGraph(int A, int [][]B, List<List<Integer>> adjList, int [] indegree){
        for(int i =0;i<=A;i++){
            adjList.add(new ArrayList<>());
        }

        for (int [] BB: B){
            adjList.get(BB[0]).add(BB[1]);
            indegree[BB[1]]++;
        }
    }

    public static void main(String[] args) {
        int A = 6;
        int [][] B = {  {6, 3},
                {6, 1},
                {5, 1},
                {5, 2},
                {3, 4},
                {4, 2 } };
        System.out.println(topoSort(A, B));
    }
}
