package Scal.Graph;
/*
Problem Description
Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:
The value 0 representing an empty cell.
The value 1 representing a fresh orange.
The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
 */
import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangeNoExtraSpace {

    //Directions
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int getCountOfOranges(int[][] A) {
        if(A == null || A.length == 0 || A[0].length == 0) return 0;

        Queue<Pair> queue = new LinkedList<>();
        int freshOranges = 0;
        for(int i = 0 ; i <  A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 2) {
                    //add rotten oranges to queue
                    queue.add(new Pair(i, j));
                }
                if (A[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int minutes = 0; // this is basically number of levels in BFS
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //continue the bfs till there are no more valid fresh oranges that can be rotten
        while(!queue.isEmpty() && freshOranges > 0){
            int sz = queue.size();
            for(int i = 0 ; i < sz ; i++){
                Pair p = queue.poll();
                for (int d =0;d<4;d++){
                    int x = p.x + dx[d];
                    int y = p.y + dy[d];
                    //checking if node is a fresh orange which lies inside the matrix
                    if(x < 0 || y < 0 || x >= A.length || y >= A[0].length || A[x][y] == 0 || A[x][y] == 2){
                        continue;
                    }
                    A[x][y] = 2;
                    queue.offer(new Pair(x, y));
                    freshOranges--;
                }
            }
            minutes++;
        }
        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] data = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int [][] data1= {
                {2, 0, 2, 2, 2, 0, 2, 1, 1, 0},
                {0, 1, 2, 0, 2, 0, 0, 1, 0, 1},
                {0, 1, 1, 1, 2, 0, 1, 1, 2, 1},
                {2, 0, 2, 0, 1, 1, 2, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 2, 0, 2, 2},
                {0, 2, 1, 1, 2, 2, 0, 2, 1, 2},
                {2, 1, 0, 2, 0, 0, 0, 0, 1, 1},
                {2, 2, 0, 2, 2, 1, 1, 1, 2, 2}
        };
        System.out.println(getCountOfOranges(data));
        System.out.println(getCountOfOranges(data1));
    }
}
