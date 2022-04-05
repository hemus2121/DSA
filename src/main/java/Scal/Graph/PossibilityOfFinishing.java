package Scal.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Possibility of Finishing
Problem Description

There are a total of A courses you have to take, labeled from 1 to A.
Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.
 */
public class PossibilityOfFinishing {
    static int solve (int A, int []B, int [] C){
        List<List<Integer>> adjList = new ArrayList<>();
        int [] indegree = new int[A+1];
        buildGraph(adjList, indegree,A, B,C);
        int count = computeCountUsingBFSTopoSort(adjList, indegree);
        return (count== A) ? 1 :0;
    }

    static int computeCountUsingBFSTopoSort(List<List<Integer>> adjList, int [] indegree){
        Queue <Integer> q = new LinkedList<>();
        //added nodes with indegree 0
        for (int i =1;i< indegree.length;i++){
            if (indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        //BFS search and count number of nodes visited
        while (!q.isEmpty()){
            int node = q.poll();
            count++;
            for ( int neighbour : adjList.get(node)){
                indegree[neighbour]--;
                if (indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        return count;
    }
    static void buildGraph(List<List<Integer>> adjList, int[] indegree, int A, int []B, int []C){
        for (int i =0;i<=A;i++){
            adjList.add((new ArrayList<>()));
        }

        // add edges and increase indegree for it terminating edge
        for (int i =0;i < B.length;i++){
            adjList.get(B[i]).add(C[i]);
            indegree[C[i]]++;
        }
    }
    public static void main(String[] args) {
        System.out.println(solve(3, new int[]{1,2}, new int[]{2, 3}));
        System.out.println(solve(2, new int[]{1,2}, new int[]{2, 1}));
    }
}
