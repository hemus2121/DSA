package Scal.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Number of Distinct Islands -https://bit.ly/3AsA08W **
 * Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).
 * TC: O( N* M *log (N*M) [this log capture set length for elements] + N * M * 4
 * SC: O(N x M),
 */
public class NoOfIslandsDistinct {
    int [] dx  = { 1, 0, -1, 0};
    int [] dy =  { 0, 1, 0, -1};

    void dfs(int row, int col, int [][] grid, int [][] visited, List<String> result, int baserow, int basecol ){
        visited[row][col ] =1;
        result.add (toString (row-baserow, col- basecol));
        int n = grid.length;
        int m = grid[0].length;
        for  (int d =0;d< 4;d++){
             int nrow = row + dx[d];
             int ncol = col + dy[d];

             if (nrow >=0  && ncol >=0 && nrow < n && ncol < m  && grid [nrow][ncol]== 1 && visited[nrow][ncol]==0 ){
                 dfs(nrow, ncol, grid, visited, result, baserow, basecol);
             }
        }
    }
    private String toString(int r, int c){
        return r+ " " + c;
    }
    private int countIslands (int [][]grid){
        int n = grid.length;
        int m = grid[0].length;

        Set<List<String>> st = new HashSet<>(); // storing pattern to get distinct values
        int [][] visited = new int [n][m];
        for (int i =0;i< n;i++){
            for (int j =0;j< m;j++){
                if (visited[i][j] ==0 && grid[i][j]==1){
                    List <String> result = new ArrayList<>();
                    dfs(i, j, grid, visited, result, i, j);
                    st.add(result);
                }
            }
        }
        return st.size();
    }


    //Solving using DFS - Extension of No Of Islands Problem
    public static void main(String[] args) {
       int  grid[][] = {{1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}};
        NoOfIslandsDistinct noOfIslandsDistinct = new NoOfIslandsDistinct();
        System.out.println(noOfIslandsDistinct.countIslands(grid));// expected 1
    }
}
