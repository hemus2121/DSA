package Scal.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
Problem Description
You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
Given 2 towns find whether you can reach the first town from the second without repeating any edge.
B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i.
 */
public class FirstDepthFirstSearch {
     static  int computeFirstDepth(ArrayList<Integer> A, final int B, final int C){

         // construct graph
         List<List<Integer>> adjList = new ArrayList<>();
         for (int i =0;i<=A.size();i++){
             adjList.add(new ArrayList<>());
         }

         // Add edges- directed path so just add  directed graph only
         for (int i =0;i<A.size();i++){
             adjList.get(A.get(i)).add(i+1);
         }

         return compute(adjList, B, C);
     }

      static  int compute(List<List<Integer>> adjList , int b, int c){

          Stack<Integer> s = new Stack<>();
          boolean [] visited = new boolean[adjList.size()+1];
          s.add(c);
          visited[c] = true;

          while (!s.isEmpty ()) {

              int node = s.pop ();
              if (node == b) return 1;
              for(Integer child:adjList.get(node)){
                  if (!visited[child]){
                      visited[child]=true;
                      s.push(child);
                  }
              }
          }
          return 0;
      }

    public static void main(String[] args) {
        ArrayList <Integer> data1 = new ArrayList<>(Arrays.asList(1,1,2));

        System.out.println(computeFirstDepth(data1,1,2));
        System.out.println(computeFirstDepth(data1,2,1));
    }
}
