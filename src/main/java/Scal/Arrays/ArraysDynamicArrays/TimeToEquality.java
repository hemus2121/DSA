package Scal.Arrays.ArraysDynamicArrays;
/*
Problem Description
Given an integer array A of size N. In one second, you can increase the value of one element by 1.

Find the minimum time in seconds to make all elements of the array equal.
 */
public class TimeToEquality {
    private static int solve(int []A){
        //find maximum element
        int max = A[0];
        for (int a: A){
            if (a > max){
                max = a;
            }
        }

        //compute difference between max and each array element
        int minimumTime =0;
        for (int a: A){
            minimumTime += max-a;
        }
        return  minimumTime;
    }
    public static void main(String[] args) {
        int [] data = {2, 4, 1, 3, 2};
        System.out.println(solve(data));
    }
}
