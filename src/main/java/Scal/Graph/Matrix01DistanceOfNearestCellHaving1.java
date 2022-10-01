package Scal.Graph;

import java.util.LinkedList;
import java.util.Queue;

/** 01 Matrix - https://leetcode.com/problems/01-matrix/
 * Problem Statement: Given a binary grid of N*M. Find the distance of the nearest 1 in the grid for each cell.
 * <p>
 * The distance is calculated as |i1  – i2| + |j1 – j2|, where i1, j1 are the row number and column number of the current cell, and i2, j2 are the row number and column number of the nearest cell having value 1.
 *
 * TC : O(NxM + NxMx4) ~ O(N x M) - For the worst case, the BFS function will be called for (N x M) nodes, and for every node, we are traversing for 4 neighbors, so it will take O(N x M x 4) time.
 * SC : O(N x M) + O(N x M) + O(N x M) ~ O(N x M)
 * O(N x M) for the visited array, distance matrix, and queue space takes up N x M locations at max.
 */
public class Matrix01DistanceOfNearestCellHaving1 {

    class Pair {
        int row, col, dist;
        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        //Usage of multiSource BFS
        private int[][] nearest(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            int[][] visited = new int[n][m];
            int[][] dist = new int[n][m];

            Queue<Pair> q = new LinkedList<>();
            // Need to add cells whose value is 1 - multi Source BFS
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        q.add(new Pair(i, j, 0));
                        visited[i][j] = 1; // mark starting nodes as visited
                    }
                }
            }

            // BFS traversal
            while (!q.isEmpty()){
                Pair pair = q.poll();
                int row = pair.row;
                int col = pair.col;
                int distance = pair.dist;
                dist[row] [col] = distance;

                for (int d =0;d< 4;d++){
                     int nrow = row + dx[d];
                     int ncol = col + dy[d];

                     //check for  valid condition - boundary and NOT visited
                    if( nrow >=0 && nrow < n && ncol >=0 && ncol <m && visited[nrow][ncol] == 0){
                        visited[nrow][ncol] =1;
                        q.add(new Pair(nrow, ncol, distance+1));
                    }
                }
            }
            return dist;
        }

        public static void main(String[] args) {
            int[][] grid = {
                    {0, 1, 1, 0},
                    {1, 1, 0, 0},
                    {0, 0, 1, 1}
            };
            Matrix01DistanceOfNearestCellHaving1 matrix01DistanceOfNearestCellHaving1 = new Matrix01DistanceOfNearestCellHaving1();
            grid = matrix01DistanceOfNearestCellHaving1.nearest(grid);

            //Print matrix
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    System.out.print(grid[i][j] + "");
                }
                System.out.println();
            }
        }
    }
