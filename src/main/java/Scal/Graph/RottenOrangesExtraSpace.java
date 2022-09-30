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

/* https://leetcode.com/problems/rotting-oranges/discuss/1741380/JAVA-or-BFS-or-1ms */

public class RottenOrangesExtraSpace {

    static class Pair {
        int x,y, time;
        Pair(int x, int y, int time){
            this.x = x;
            this.y =y;
            this.time = time;
        }
    }

    static int getCountOfOranges(int [][]A) {

        int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
        int row = A.length;
        int col = A[0].length;
        int count=0,max=0;

        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col]; // EXTRA SPACE to hold visited Information

        // add all initial elements to Queue - multi source BFS
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(A[i][j]==2){
                    queue.add(new Pair(i,j,0));
                }
            }
        }
        // BFS search
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            visited[p.x][p.y]=true;

            for(int dr[] : dir){
                int i = p.x+dr[0];
                int j = p.y+dr[1];

                if(isValidDir(i,j,A) && A[i][j]==1 && !visited[i][j]){
                    A[i][j]=2;
                    queue.add(new Pair(i,j,p.time+1));
                }
            }
            max=Math.max(max,p.time);
        }

        // find max element from matrix- if initial matrix has value 1 which is not rotten still
        for(int rows[] : A){
            for(int cols : rows){
                if(cols==1) count++;
            }
        }
        return count>0 ? -1 : max;
    }

    static boolean isValidDir(int i,int j,int A[][]){
        if(i<0 || i>=A.length|| j<0 || j>=A[0].length) return false;
        return true;
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
        int [][] data3 ={
                {1, 1, 0, 1, 2, 0},
                {1, 2, 2, 1, 2, 2},
                {1, 0, 0, 0, 0, 0},
                {0, 2, 0, 2, 1, 0},
                {0, 2, 0, 1, 0, 0},
                {2, 0, 0, 0, 0, 0},
                {1, 2, 2, 0, 0, 1},
                {1, 2, 0, 1, 0, 0}
        };
        System.out.println(getCountOfOranges(data));
        System.out.println(getCountOfOranges(data1));
        System.out.println(getCountOfOranges(data3));
    }
}
