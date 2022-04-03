package Scal.Graph;

/*
Number of islands
Problem Description

Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island.
From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.
 */
public class NoOfIslands {

    // first 4 coordinates denote top, down ,left- mark center coordinate as (0,0) and write all directions in array
    static int [] dx= {-1,1,0,0,  1, 1,-1,-1};
    static int [] dy ={ 0,0,-1,1, 1,-1, 1,-1};

    private static  int countIsLands(int [][]A){
        int noofIslands=0;
        // iterate over matrix for finding count of components
        for (int i =0;i< A.length;i++){
            for (int j =0;j< A[0].length;j++){
                // if value of node is not ZERO
                if (A[i][j]!=0){
                    noofIslands++;
                    dfs(i,j,A);
                }
            }
        }
        return noofIslands;
    }

    // Normal DFS method to visit cells of matrix
    static void dfs(int i, int j, int [][] A){
        //marking current cell as visited
        A[i][j]=0;
        for (int d =0; d<8;d++){
            //compute new coordinates
            int x = i + dx[d];
            int y = j + dy[d];
            // check boundary condition and cell is not visited
            if ( x >=0 && y >=0 && x <A.length && y <A[0].length && A[x][y]!=0 ){
                dfs(x, y, A);
            }
        }
    }

    public static void main(String[] args) {
        int [][] data = {
                {0, 0, 1, 0, 1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 0, 1}
        };
        System.out.println(countIsLands(data));
    }
}
