package Scal.Hashing;

import java.util.HashMap;
import java.util.Map;
/*
Problem Description

Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.
Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (109 + 7).
 */
public class CountOfTriangles {
    private static int getTrinaglesCount(int []A, int []B){

        //construct 2 hash maps for 2 arrays which denote x and y co ordinates respectively
        // each map represent point along with frequency
        Map <Integer,Integer> xcoordinatesMap = new HashMap<>();
        Map <Integer,Integer> ycoordinatesMap = new HashMap<>();
        for (int i =0;i<=A.length-1;i++){
            xcoordinatesMap.put(A[i], xcoordinatesMap.getOrDefault(A[i],0)+1);
            ycoordinatesMap.put(B[i], ycoordinatesMap.getOrDefault(B[i], 0)+1);
        }

        //compute result which is numbor of (x coor-1) * (y coor-1) since
        // considering x, y point is considered  as middle point
        int totalTriangles=0;
        for (int i =0;i<A.length;i++){
            totalTriangles += (xcoordinatesMap.get(A[i])-1 ) * (ycoordinatesMap.get(B[i])-1);
        }
        return totalTriangles;
    }
    public static void main(String[] args) {
        int [] A= {1,1,2};
        int [] B= {1,2,1};
        System.out.println(getTrinaglesCount(A,B));

        int [] AA= {1, 1, 2, 3, 3};
        int [] BB= {1, 2, 1, 2, 1};
        System.out.println(getTrinaglesCount(AA,BB));

    }
}
