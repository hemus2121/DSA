package Scal.TwoPointers.Homework;
/*
Problem Description

You are given 3 sorted arrays A, B and C.
Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
 */
public class Array3Pointers {

    private static int getminimum(final int [] A, final int [] B, final int []C){
        int minDiff = Integer.MAX_VALUE;
        int minValue =-1;

        //iterate over all 3 arrays
        for (int i=0,j=0,k=0;(i < A.length && j < B.length && k < C.length); ){
            minDiff  = Math.min(minDiff, Math.max(Math.abs(A[i]-B[j]),Math.max( Math.abs(B[j]-C[k]),Math.abs(C[k]-A[i]))));
            //find the minimum index among 3 indexex since we dont know what next possible answer is
            minValue = Math.min(A[i], Math.min(B[j],C[k]));

            //since we need to minimize diff we need to increment in specific array where minimum is found
            if (minValue== A[i])i++;
            else if (minValue == B[j])j++;
            else if (minValue==C[k]) k++;
    }
        return minDiff;
    }
    public static void main(String[] args) {
        int [] A = {1,4,10};
        int [] B={ 2,15,20};
        int [] C={10,12};
        System.out.println(getminimum(A,B,C));
    }

}
