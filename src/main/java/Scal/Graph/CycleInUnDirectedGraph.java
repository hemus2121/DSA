package Scal.Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInUnDirectedGraph {
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    //using BFS way of detecting cycle
    static int isCyclePresent(int A, int[][] B) {
        buildGraph(A, B);
        boolean visited[] = new boolean[A + 1];
        //check for each nodes present -whether its visited and isCyclePresent
        for (int i = 1; i <= A; i++) {
            if (!visited[i] && isCycleConnected(A, visited, i)) return 1;
        }
        return 0;
    }

    //Using BFS way of traversal - using 2 arrays - visited and parent
    static boolean isCycleConnected(int A, boolean[] visited, int start) {

        //create a parent array
        int[] parent = new int[A + 1];
        Arrays.fill(parent, -1);

        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        que.add(start);

        //BFS
        while (!que.isEmpty()) {
            int node = que.remove();
            for (int neighbour : adjList.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    que.add(neighbour);
                    parent[neighbour] = node;
                } else if (parent[node] != neighbour) {
                    //this denotes that node is already visited and its parent is different
                    return true;
                }
            }
        }
        return false;
    }

    static void buildGraph(int A, int[][] B) {
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<>());
        }
        //construct edges given - directed graph mentioned
        for (int[] edge : B) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }

    public static void main(String[] args) {
        //  int A=5;
//        int {}{} B= {
//                {1, 2},
//                {1, 3},
//                {2, 3},
//                {1, 4},
//                {4, 5}
//        };

//        int A=4;
//        int {}{} B= {
//                {1, 2},
//                {2, 3},
//                {3, 4}
//        };
        int A = 99;
        int[][] B = {
                {5, 96},
                {38, 99},
                {30, 77},
                {51, 88},
                {48, 55},
                {41, 53},
                {26, 86},
                {16, 68},
                {30, 48},
                {45, 76},
                {21, 63},
                {6, 13},
                {23, 61},
                {20, 69},
                {27, 77},
                {42, 63},
                {31, 88},
                {39, 68},
                {40, 41},
                {60, 65},
                {17, 19},
                {79, 87},
                {41, 64},
                {69, 99},
                {59, 95},
                {65, 69},
                {37, 74},
                {35, 42},
                {88, 89},
                {47, 92},
                {50, 92},
                {59, 80},
                {70, 79},
                {24, 76},
                {59, 87},
                {71, 99},
                {32, 96},
                {5, 12},
                {38, 67},
                {53, 63},
                {30, 53},
                {36, 76},
                {40, 76},
                {39, 88},
                {43, 81},
                {11, 74},
                {65, 89},
                {22, 34},
                {34, 56},
                {23, 71},
                {71, 81},
                {8, 61},
                {29, 55},
                {8, 34},
                {37, 52},
                {77, 90},
                {53, 75}
        };
        // System.out.println(isCyclePresent(A, B));
        System.out.println(isCyclePresent(A, B));
    }
}