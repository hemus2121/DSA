package Scal.BinarySearch2.Assi;

/*
Problem Description

Given an array of integers A and an integer B, find and return the maximum value K
 such that there is no subarray in A of size K with sum of elements greater than B.
 */
public class SpecialInteger {
    private static int getSpecialInteger(int []A, int B){
     int ans =0;
     //define search space
     int l =1; int r = A.length;
     while (l<=r) {
         int mid = (l + r) / 2;
         if (check(A, mid, B)) {
             ans = mid;
             l = mid + 1;
         } else r = mid - 1;
     }
     return ans;
    }

    //its sliding window of size of k to check it is possible or not
    //k denotes window size
    private static boolean check(int []A, int k, int B){
        int sum= 0;
        //get summation upto k window as of now
        for (int i =0;i<k;i++){
            sum = sum + A[i];
        }
        if (sum >B) return false;
        //slide over window till the length of the Array
        for (int i =k;i<A.length;i++){
            sum += A[i];
            sum =  sum -A[i-k];
            if (sum > B ) return false;
        }
        return true;
    }
    public static void main(String[] args) {
     int [] A = {1,2,3,4,5};
     int B = 10;
     System.out.println(getSpecialInteger(A, B));

     int [] AA = { 5,17,100,11};
     int BB= 130;
        System.out.println(getSpecialInteger(AA,BB));
    }

}
