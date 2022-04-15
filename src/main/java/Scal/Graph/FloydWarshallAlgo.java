package Scal.Graph;
/*
Problem Description

Given a matrix of integers A of size N x N, where A[i][j] represents the weight of directed edge from i to j (i ---> j).
If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.
Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.
If there is no possible path from vertex i to vertex j , B[i][j] = -1
Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 */

public class FloydWarshallAlgo {
    private static int [][] computeFloydAlgo (int [][]A){

        // create placeholder for distance matrix
        int row = A.length;
        int col = A[0].length;

        int [][] dist = new int[row][col];

        //build adj matrix
        for (int i=0;i< row;i++){
            for (int j =0;j <col; j++){
                if (A[i][j]==-1){
                    dist [i] [j] = (int)(1e9);
                }else dist[i][j] = A[i][j];
            }
        }

        // compute using algo
        for (int k =0;k< row ;k++){
            for (int i =0;i< row;i ++){
                for (int j =0;j< col; j++){
                    dist [i][j] = Math.min(dist[i][j], dist[i][k]+ dist[k][j]);
                }
            }
        }

        // revamp output array
        for (int i =0;i< row;i++){
            for (int j =0;j< col;j++){
                if (dist[i][j] == (int)(1e9)){
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
                {-1, 10, 0}
        };

        System.out.println(computeFloydAlgo( A));

    }
}
