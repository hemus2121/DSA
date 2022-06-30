package Scal.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/** Shortest Distance in Maze
 * Problem Description
 * Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.
 * 1 represents a wall in a matrix and 0 represents an empty location in a wall.
 * There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.
 * Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.
 * Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
 */
public class ShortestDistanceInMaze {

    public static int computeShortestDistance(int [][] maze, int [] source, int [] dest){

        int rowLen = maze.length;
        int colLen = maze[0].length;
        int [][] distance = new int[rowLen][colLen];

        //lets initialize matrix with MAX values, later we shall update with min value if computed
        for (int [] dist : distance){
            Arrays.fill(dist, Integer.MAX_VALUE);
        }

        distance[source[0]][source[1]]=0;
        // directions for BFS traversal
        int [][] dirs = new int [] [] {{-1,0},{0,-1},{1,0},{0,1}};

        Queue<int[]> que = new LinkedList<>();
        que.add(source);

        while (!que.isEmpty()){
            int [] curr = que.poll();

            //iterate in all 4 directions
            for (int [] dir : dirs){
                int dx = curr[0]+dir[0];
                int dy = curr[1]+dir[1];
                int count =0;

                // keep iterating in all 4 all directions and when maze cell is empty since ball cannt stop in between
                while (dx >=0 && dx < maze.length && dy >=0 && dy <maze[0].length && maze[dx][dy]==0){
                    dx += dir[0];
                    dy += dir[1];
                    count++;
                }

                // check if new distance is less than previous distance- update if YES
                if (distance[curr[0]][curr[1]]+ count < distance[dx-dir[0]][dy-dir[1]]){
                    distance[dx-dir[0]][dy-dir[1]] = distance[curr[0]][curr[1]] +count;
                    que.offer(new int [] {dx-dir[0], dy-dir[1]});
                }
            }
        }
        //return destination cell distance value
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1: distance[dest[0]][dest[1]];
    }

    public static void main(String[] args) {
        int [][] A = {
                {0,0,},
                {0,0},

        };
        int [] B = {0,0},C = {0,1};
        System.out.println(computeShortestDistance(A, B, C)); //expected 1;
        int [][] AA = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                { 0,0,0,0,0},
                { 1,1,0,1,1},
                {0,0,0,0,0}
        };
        int [] BB = {0,4}, CC = {4,4};
        System.out.println(computeShortestDistance(AA, BB, CC)); //expected -1;
    }
}
