package Scal.Graph;

/*
Problem Description

Given a matrix of integers A of size N x N, where A[i][j] represents the weight of directed edge from i to j (i ---> j).
If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.
Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.
If there is no possible path from vertex i to vertex j , B[i][j] = -1
Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 */

import java.util.Arrays;

public class FloydWarshallAlgo {
    private static int [][] computeFloydAlgo (int [][]A){

        // create placeholder for distance matrix
        int row = A.length;
        int col = A[0].length;
        int DUMMY_VALUE = 1000000000;

        //adjacency matrix to have distance between all the nodes
        int [][] dist = new int[row][col];

        //build adj matrix from input matrix
        for (int i=0; i< row;i++){
            for (int j =0; j <col; j++){
                // if input value is -1 setting dummy value to the cell
                if (A[i][j] == -1) dist [i] [j] = DUMMY_VALUE;
                else dist[i][j] = A[i][j];
            }
        }

        // compute using Floyds algo
        for (int k =0; k< row ;k++){
            for (int i =0; i< row;i ++){
                for (int j =0; j< col; j++){
                    dist [i][j] = Math.min(dist[i][j], dist[i][k]+ dist[k][j]);
                }
            }
        }

        // Check if any of the cell value not revised, set it to -1 as mentioned in question
        for (int i =0;i< row;i++){
            for (int j =0;j< col;j++){
                if (dist[i][j] == DUMMY_VALUE){
                    dist [i][j]= -1;
                }
            }
        }
        return  dist;
    }

    public static void main(String[] args) {
        int [] [] A = {
                {0, 50, 39},
                {-1, 0, 1},
                {-1, 10, 0} };
        System.out.println(Arrays.toString(computeFloydAlgo(A)));
    }
}
