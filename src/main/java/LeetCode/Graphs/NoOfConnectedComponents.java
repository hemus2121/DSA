package LeetCode.Graphs;

import java.util.HashSet;
import java.util.Set;

/** Number of connected components in undirected Graph
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
 * Return the number of connected components in the graph.
 */
public class NoOfConnectedComponents {

    static class UnionFind{
        // 2 arrays to hold information about the parent and rank of each node.
        private int [] parent;
        private int [] rank;

        public UnionFind(int size){
            parent = new int [size];
            rank = new int [size];

            //Initializing both arrays
            for (int i =0;i< size;i++){
                parent [i] = i;
                rank [i] = 1; // init value of the rank
            }
        }

        public void union(int x, int y){
            //find parent of each node
            int px = find (x);
            int py = find (y);
            // if both parents are same just return
            if (px == py) return ;
            if (rank[px] >= rank[py]){
                parent[py] = px;
                rank[px] += rank[py];
            }else {
                parent[px] = py;
                rank[py] += px;
            }
        }

        public int find(int x){
            //base case  If  node is  parent of itself then it is the leader of tree.
            if (x == parent[x])return x;
            //main logic
            //  //Else, finding parent and also compressing the paths.
            return parent[x]= find(parent[x]);
        }
    }

    static public int countComponents(int n, int[][] edges) {

        UnionFind uf = new UnionFind( n);
        // invoke union for each consecutive edges
        for (int [] edge : edges){
            uf.union(edge[0],edge[1]);
        }

        //Get count of unique parent
        Set<Integer> countSet = new HashSet<>();
        for (int i =0;i < n;i++){
            countSet.add(uf.find(i));
        }
        return countSet.size(); // this contains count of unique parents
    }

    public static void main(String[] args) {
        int n =5;
        int [] [] edges = {
                {0,1},
                {1,2},
                {3,4}
        };
        System.out.println(countComponents(n, edges)); //expected 2

        int [][] edges1 = {
                {0,1},
                {1,2},
                {2,3},
                {3,4}
        };
        System.out.println(countComponents(5,edges1)); //expected 1
    }

}
