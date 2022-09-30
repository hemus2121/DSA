package Scal.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/** Valid Path
 * Problem Description
 * There is a rectangle with left bottom as (0, 0) and right up as (x, y).
 * There are N circles such that their centers are inside the rectangle.
 * Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
 * Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.
 *
 * Input Format
 * 1st argument given is an Integer x , denoted by A in input.
 * 2nd argument given is an Integer y, denoted by B in input.
 * 3rd argument given is an Integer N, number of circles, denoted by C in input.
 * 4th argument given is an Integer R, radius of each circle, denoted by D in input.
 * 5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle
 * 6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle
 */
public class ValidPath {

    static int [] dx={0, 1, 0, -1, 1, 1, -1, -1};
    static int [] dy ={1, 0, -1, 0, 1,-1, 1, -1};

    static public String findPath (int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F ){

        // A, B destination coordinates  C - Number of circles  D--Radius of circle E, E--> (x, y) coordinates of each circle

        // step -1 construct adjacency matrix
        int [][] adjMatrix = new int [A+1][B+1];

        // step 2- Iterate till A, B coordinates and check whether they lie inside a circle coordinate - IMP
        for (int i=0;i<=A; i++){
            for (int j=0;j<=B;j++){
                //iterate till number of circles present
                for (int k=0; k < C;k++){
                    //check whether coordinates are within circle- if YES mark them as -1 (invalid state)
                    if (Math.sqrt(Math.pow(E.get(k) - i, 2) + Math.pow(F.get(k) - j, 2)) <= D){
                        adjMatrix[i][j] = -1;
                    }
                }
            }
        }

        //check if starting and ending coordinates are within Circle radius
        if ( adjMatrix[0][0]==-1 || adjMatrix [A][B]==-1) return "NO";

        // lets to BFS for adjacency matrix
        Queue <Integer> q = new LinkedList ();
        q.add(0);
        q.add(0);
        adjMatrix[0][0] = -1;
        while (!q.isEmpty()) {
            int i = q.poll();
            int j = q.poll();

            // check if coordinates are matching to destination
            if (i == A && j == B)  return "YES";

            for (int z = 0; z < 8; z++) {
                int ix = i + dx[z];
                int iy = j + dy[z];

                if(ix>=0 && iy>=0 && ix<=A && iy<=B && adjMatrix[ix][iy]!=-1){
                    q.add(ix);
                    q.add(iy);
                    //set the adj matrix as visited
                    adjMatrix[ix][iy] = -1;
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        int A = 2;
        int B = 3;
        int C = 1;
        int D = 1;
       ArrayList<Integer> xcor = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer> ycor = new ArrayList<>(Arrays.asList(2));
        System.out.println(findPath(A, B,  C,  D, xcor, ycor));
    }
}
