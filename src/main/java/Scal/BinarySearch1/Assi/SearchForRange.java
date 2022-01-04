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
        int [] res = new int [2];
        res[0] = firstIndex (A, B);
        res[1] = lastIndex(A, B);
        return res;
    }
    private static int firstIndex(int []A, int B){
        int l=0;int r = A.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            //condition is element is matching exactly AND (mid==0 OR current element NOT equal to previous)
            if (A[mid]==B && (mid==0 || A[mid]!=A[mid-1])){
                return mid;
            }
            if (A[mid]<B) l= mid+1;
            else r = mid-1;
        }
        return -1;
    }
    private static int lastIndex(int [] A, int B){
        int l =0;int r = A.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            //condition is element is matching exactly AND (mid==length-1 OR current element NOT equal to next)
            if (A[mid]==B && (mid == A.length-1 || A[mid] != A[mid+1])){
                return mid;
            }
            if (A[mid]<B)  l = mid+1;
            else r = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] A = { 5, 7, 7, 8, 8, 10};
        int B = 8;
        System.out.println(Arrays.toString(searchRange(A,B)));

    }
}
