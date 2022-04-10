package Scal.Graph;

/*
Construction Cost
Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.
Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.
NOTE: Return the answer modulo 109+7 as the answer can be large.

Input Format
First argument is an integer A.
Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected by ith edge with weight B[i][2]
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Kruskal Algo - MST
public class ConstructionCostKruskalAlgo {

    static int[] parentArray;
    static int mod = (int) Math.pow(10, 9) + 7;

    // custom object type to store the edge and weight information
    static class Pair {
        int u, v, weight;
        Pair(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static class CustomComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.weight - o2.weight;
        }
    }

    private static int computeMinimumCostUsingKruskal(int A, int[][] B) {

        List<Pair> adjList = new ArrayList<>();
        buildGraph(adjList, B);

        // sort the edges by weight in ascending order
        Collections.sort(adjList, new CustomComparator());

        // initialize parent array. this means every node is parent of itself[each node
        // represents unique connect component initially]
        parentArray = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            parentArray[i] = i;
        }

        // check for edge if it can be considered in minimum spanning tree
        int minCost = 0;
        for (Pair edge : adjList) {
            // combines 2 different components at a given time
            if (union(edge.u, edge.v)) {
                // if edge is considered, add weight to cost
                minCost = (minCost + edge.weight) % mod;
            }
        }
        return minCost;
    }

    //Method to find merge 2 components based on common root
    static boolean union(int x, int y) {
        int root_x = findRoot(x);
        int root_y = findRoot(y);
        if (root_x != root_y) {
            parentArray[root_x] = root_y;
            return true;
        }
        return false;
    }

    //using recursion to find the root reduce TC
    static int findRoot(int x) {
        // base case when parent of node is itself
        if (parentArray[x] == x) return x;
        // get parent and assign same parent to all its children
        parentArray[x] = findRoot(parentArray[x]);
        return parentArray[x];
    }

    // build edge list
    static void buildGraph(List<Pair> adjList, int[][] B) {
        for (int[] bb : B) {
            adjList.add(new Pair(bb[0], bb[1], bb[2]));
        }
    }

    public static void main(String[] args) {
        int [][] B = {
                {1, 2, 14},
                {2, 3, 7},
                {3, 1, 2} };
        System.out.println(computeMinimumCostUsingKruskal(3,B));

        int [][] BB = {
                {1, 2, 20},
                {2, 3, 17} };
        System.out.println(computeMinimumCostUsingKruskal(3,BB));
    }
}
