package Scal.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoard {

    static int rows, cols;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1,  2,  2, 1, -1, -2};
    static int dest_x, dest_y;
    static int[][] visited;

    static class Pair {
        int x, y, count;

        Pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.count = cost;
        }
    }

    private static int checkKnightOnChessBoard(int A, int B, int C, int D, int E, int F) {
        // invalid case
        if(A<E || A<C || B<D || B<F) return -1;

        visited = new int [A+1][B+1];
        Queue<Pair> q= new LinkedList();
        q.add(new Pair(C,D,0));
        visited[C][D] =1;

        while(!q.isEmpty()){
            Pair curr = q.poll();

            //if destination reached return count
            if(curr.x==A && curr.y==B)
                return curr.count;

            //iterate for all possible positions from current position
            for(int i=0;i<8;i++){
                int new_x = curr.x+dx[i];
                int new_y = curr.y+dy[i];
                if(isValidMove(new_x,new_y, A, B)){
                    visited[new_x][new_y]=1;
                    q.add(new Pair(new_x,new_y, curr.count+1));
                }
            }
        }
        return -1;
    }

    //checking boundary conditions and whether node is visited already
    private static boolean isValidMove(int i,int j,int A, int B){
        if(i<=0 || i>A || j<=0 || j>B || visited[i][j]==1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkKnightOnChessBoard(8, 8, 1, 1, 8, 8));  //expected : 6

        System.out.println(checkKnightOnChessBoard(2, 4, 2, 1, 4, 4));  //expected : -1
    }
}
