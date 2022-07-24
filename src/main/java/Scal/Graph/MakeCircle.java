package Scal.Graph;

import java.util.ArrayList;
import java.util.List;

/** Make Circle
 * Problem Description
 * Given an array of strings A of size N, find if the given strings can be chained to form a circle.
 * A string X can be put before another string Y in circle if the last character of X is same as first character of Y.
  * NOTE: All strings consist of lower case characters.
 **/


public class MakeCircle {

    static int charCount =26;
    //We need to check 2 criteria - using Strongly connected component concept
    // 1. whether ind  and out degree edges are equal
    // 2. Graph is strongly connected
    // If 1 && 2 conditions are satisfied then 1 otherwise 0

    private static int checkForCircle(String [] A){

        boolean [] mark = new boolean[charCount];
        int [] inDegree = new int [ charCount];
        int [] outDegree= new int [ charCount];
        List<List<Integer>> adjList = new ArrayList<>();
        buildGraph(A, adjList, inDegree, outDegree, mark);
        return checkForCircleFormation(A, adjList, inDegree, outDegree, mark);
    }

    private static int checkForCircleFormation(String [] A, List<List<Integer>> adjList, int[] inDegree, int[] outDegree, boolean[] mark) {
        //if inDegree != outDegree then return 0;
        for (int i =0;i< charCount;i++ ){
            if (inDegree[i]!= outDegree[i]){
                return 0;
            }
        }

        int [] visited =new int [ 26];
        dfs(adjList, visited, A[0].charAt(0)-'a');

        //check if all nodes are visited - strongly connected
        for (int i =0;i< charCount;i++){
            if (mark[i] && visited[i]==0){
                return 0;
            }
        }
        return 1;
    }

    // DFS to search that graph is strongly connected
    private static void dfs(List<List<Integer>> adjList, int[] visited, int  src) {
        visited[src]=1;
        for (int it : adjList.get(src)){
            if (visited[it]==0){
                dfs(adjList, visited, it);
            }
        }
    }

    //building Graph way
    private static void buildGraph(String[] A, List<List<Integer>> adjList, int[] inDegree, int[] outDegree, boolean [] mark) {
        for (int i =0;i< charCount;i++){
            adjList.add(new ArrayList<>());
        }
        for (int i =0;i< A.length;i++){
            int front = (A[i].charAt(0)-'a');
            int last = (A[i].charAt(A[i].length()-1)-'a');
            //mark them visited
            mark[front] = true;
            mark[last] =true;

            //update in & out degree
            outDegree[front]++;
            inDegree[last] ++;
            adjList.get(front).add(last);
        }
    }

    public static void main(String[] args) {
        String [] data = {"aab", "bac", "aaa", "cda"}; //expected 1
        System.out.println(checkForCircle(data));
    }
}
