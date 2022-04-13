package Scal.Arrays;

/*Problem Description

Given an unsorted integer array, A of size N. Find the first missing positive integer.
Note: Your algorithm should run in O(n) time and use constant space.
*/
public class FirstMissingInteger {
    private static int firstMissingInteger(int [] A){

        int n = A.length;

        //iterate till all elements are scanned for right position
        for (int i =0;i< n;i++){

            // we will continue if and only if number is within range
            if (A[i]>0  && A[i]<n){
                // this is because arrays are ZERO based and we want to check correct index for current element
                int rightIndex = A[i]-1;
                // check if they are in correct index location
                if (A[rightIndex] != A[i]){

                    //swap if they are not in correct location
                    int temp = A[i];
                    A[i] = A[rightIndex];
                    A[rightIndex] = temp;
                    // since we swapped element let start from same index to check again 
                    i--;
                }
            }
        }
        //finally, check which index and array element is not equal we return index +1
        for (int i =0;i< n;i++){
            if ( i+1 != A[i]){
                return  i+1;
            }
        }

        //Index and array elements matched so only missing element is (n+1) element
        return  n+1;
    }
    public static void main(String[] args) {
        int [] data = {3, 4, -1, 1};
        System.out.println(firstMissingInteger(data));
    }
}
