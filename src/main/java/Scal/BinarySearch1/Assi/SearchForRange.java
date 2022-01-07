package Scal.BinarySearch1.Assi;

import java.util.Arrays;

/*
Problem Description

Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.
Your algorithm's runtime complexity must be in the order of O(log n).
Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
 */
public class SearchForRange {
    public static int [] searchRange(int []A, int B){
        int [] response = new int [2];
        response[0] = firstIndex(A,B) ==-1? -1: firstIndex(A,B);
        response[1] = lastIndex(A,B) ==-1? -1: lastIndex(A,B);
        return response;
    }
    private static int firstIndex(int []A, int B){
        int l =0;int r = A.length-1;
        int ans=-1;
        while (l<=r){
            int mid = (l+r)/2;

            // if found at middle search for better possible answer on LHS
            if (A[mid]==B){
                ans= mid;
                r=mid-1;
            }
            if (A[mid] <B) l = mid+1;
            else r = mid-1;
        }
        return ans;
    }
    private static int lastIndex(int [] A, int B){
        int l =0;
        int r = A.length-1;
        int ans=-1;
        while (l<=r){
            int mid = l+ (r-l)/2;
            // if found at middle search for better possible answer on RHS
            if (A[mid]==B){
                ans = mid;
                l =mid+1;
            }
            if (A[mid]<= B) l =mid+1;
            else r = mid-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] A = { 5, 7, 7, 8, 8, 10};
        int B = 8;
        System.out.println(Arrays.toString(searchRange(A,B)));

    }
}
