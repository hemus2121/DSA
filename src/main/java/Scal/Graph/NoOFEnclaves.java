package Scal.Graph;

import java.util.LinkedList;
import java.util.Queue;

/** Number of Enclaves
 * You are given an n x m binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
 * Find the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 *
 * TC: O(NxMx4) ~ O(N x M), For the worst case, assuming all the pieces as land, the BFS function will be called for (N x M) nodes and for every node, we are traversing for 4 neighbors, so it will take O(N x M x 4) time.
 * SC: O(N x M), O(N x M) for the visited array, and queue space takes up N x M locations at max.
 * **/
public class NoOFEnclaves {

    int [] dx = {1, 0, -1, 0 };
    int [] dy = {0, 1,  0, -1};
    class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    //compute using BFS - MultiSource BFS
    private int compute(int [][] grid){
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int [][] vis = new int [n][m];

        //lets add boundary element to Q
        for (int i =0;i< n;i++){
            for (int j =0;j< m;j++){
                if (i==0 || j==0 || i == n-1 || j == m-1){
                    if (grid[i][j]==1){
                        q.add(new Pair(i, j));
                        vis[i][j]=1;
                    }
                }
            }
        }

        while (!q.isEmpty()){
            Pair pair = q.poll();
            int row = pair.x;
            int col = pair.y;
            for (int d =0;d< 4;d++){
                int nrow = row  + dx[d];
                int ncol = col + dy [d];

                if (nrow >=0 && ncol >=0 && nrow< n && ncol < m && vis[nrow][col]==0 && grid [nrow][ncol]==1){
                    vis[nrow][ncol]=1; //mark it as visited
                    q.add(new Pair(nrow,ncol));
                }
            }
        }

        //compare input grid and visited array
        int cnt=0;
        for (int i =0;i<n;i++){
            for (int j =0;j< m;j++){
                if (grid[i][j]==1 && vis[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt++;
    }
    public static void main(String[] args) {
        int grid[][] = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};
        NoOFEnclaves noOFEnclaves = new NoOFEnclaves();
         int ans = noOFEnclaves.compute(grid);
        System.out.println(ans);
    }
}