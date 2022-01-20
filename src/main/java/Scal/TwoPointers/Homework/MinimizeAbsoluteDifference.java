package Scal.TwoPointers.Homework;

/*
Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.
 */
public class MinimizeAbsoluteDifference {

    private static int getmimimum (int []A, int []B, int []C){
        // lets denote them in reverse order from maximum to minimum
        int i = A.length-1;
        int j = B.length-1;
        int k = C.length-1;

        int min_diff, current_diff;

        int max = Math.max (A[i],Math.max(B[j],C[k]));
        int min = Math.min(A[i],Math.min(B[j],C[k]));
        min_diff = Math.abs(max-min);

        //iterate over all array elements
        while (i !=-1 && j !=-1 && k !=-1){
            current_diff = Math.abs(Math.max(A[i], Math.max(B[j], C[k]))
                    - Math.min(A[i], Math.min(B[j], C[k])));

            if (current_diff< min_diff){
                min_diff = current_diff;
            }
            // compute high contributer from elements to reduce it
            int maximum = Math.max(A[i],Math.max(B[j],C[k]));
            if (maximum == A[i])i--;
            else if (maximum == B[j])j--;
            else if (maximum == C[k])k--;
        }
        return min_diff;
    }
    public static void main(String[] args) {

        int [] A = {1,4,5, 8,10};
        int [] B ={ 6,9,15};
        int [] C={ 2,3, 6, 6};
        System.out.println(getmimimum(A,B,C));

    }
}
