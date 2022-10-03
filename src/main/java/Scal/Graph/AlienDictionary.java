package Scal.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Alien Dictionary- https://bit.ly/3C9N6ZU
 * Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
 * Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
 */
public class AlienDictionary {
    static List<List<Integer>> adjList  = new ArrayList<>();

    private static List <Integer> topoSort(int V){
        int [] indegree = new int [V];
        for (int i=0;i<V;i++ ){
            for (int it : adjList.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<V;i++){
            if (indegree[i]==0){
                q.add(i);
            }
        }

        List<Integer> topoList = new ArrayList<>();
        while (!q.isEmpty()){
            int node = q.poll();
            topoList.add( node);
            for (int neighbour : adjList.get(node)){
                indegree[neighbour]--;
                if (indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        return topoList;
    }
    //build edges based on character difference between adjacent nodes
    private static void buildGraph(String[] dict, int N, int K) {
        for (int i=0;i<= K;i++){
            adjList.add(new ArrayList<>());
        }
        for (int i =0;i< N-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr =0;ptr <len;ptr++){
                if (s1.charAt(ptr) != s2.charAt(ptr)){
                    adjList.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a'); //converting to numbers
                    break;
                }
            }
        }
    }
    public static String findOrder(String[] dict, int N, int K){
        buildGraph(dict, N, K);
        List <Integer> topoList = topoSort(K );

        //returning final result
        String res ="";
        for (int it: topoList)
            res = res + (char)(it + (int)'a');
        return res ;
    }

    public static void main(String[] args) {
        int N=5, K=4;
        String [] data ={"baa", "abcd","abca", "cab", "cad"};
        System.out.println(findOrder(data, N, K));
    }
}
