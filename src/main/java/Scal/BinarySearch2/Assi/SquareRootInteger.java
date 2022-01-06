package Scal.BinarySearch2.Assi;

/*
Problem Description

Given an integer A.
Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY.

NOTE: Do not use sort function from standard library. Users are expected to solve this in O(log(A)) time.
 */
public class SquareRootInteger {
    private static int getSqureRoot(int A){
        //longest search space is from 0 to A
        long l =0;
        long r = A;
        int ans =0;
        while (l<=r){
            long mid = l+(r-1)/2;
            long midsqu= mid * mid;
            if (midsqu==A) return (int )mid;
            if (midsqu <A){
                // this might be one of the possible solution
                ans = (int)mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(getSqureRoot(10));
    }
}
