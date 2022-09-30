package Scal.Graph;

/** Distance of the nearest cell
Problem Description

Given a matrix of integers A of size N x M consisting of 0 or 1.
For each cell of the matrix find the distance of nearest 1 in the matrix.
Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.
Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.

NOTE: There is at least one 1 is present in the matrix. */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCell {
        static int [] dx = {0, 0, 1, -1};
        static int [] dy = {1, -1, 0, 0};

    static class Pair {
        int x, y;
        Pair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int [][] nearestCell(int [][]A){
        // we need to store distance in 2D array
        int [][] ans = new int[A.length][A[0].length];

        //Traversal using BFS
        Queue<Pair> queue = new LinkedList<>();

        for (int i =0;i< A.length;i++){
            for (int j =0;j< A[0].length;j++){
                if (A[i][j]== 1){
                    ans[i][j]=0;
                    queue.add(new Pair(i, j));
                }else {
                    ans [i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // BFS search
        while (!queue.isEmpty()){
            Pair pair = queue.poll();

            for (int i=0;i<4;i++){
                int x = pair.x + dx[i];
                int y = pair.y + dy[i];
                //check boundary conditions
                if(x>=0 && x<A.length && y>=0 && y<A[0].length ) {
                    if (ans[x][y]== Integer.MAX_VALUE) {
                        ans[x][y] = Math.min(ans[x][y], ans[pair.x][pair.y] + 1);
                        queue.offer(new Pair(x, y));
                      }
                    }
                }
            }
        return  ans;
    }
    public static void main(String[] args) {
        int [] [] data =  {
            {1,0,0},
            {0,0,0},
            {0,0,0}
        };

        System.out.println(Arrays.toString(nearestCell(data)));

        int [][] data1 = {
                {1, 1, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0}
        };
        System.out.println(Arrays.toString(nearestCell(data1)));
    }
}
