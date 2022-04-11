package Scal.Arrays;

/*Problem Description

Given an unsorted integer array, A of size N. Find the first missing positive integer.
Note: Your algorithm should run in O(n) time and use constant space.
*/
public class FirstMissingInteger {
    private static int firstMissingInteger(int [] A){
        int n = A.length;

        for (int i =0;i< n;i++){

            // we will continue if and only if number is within range
            if (A[i]>0  && A[i]<n){

                int rightIndex = A[i]-1;
                // check if they are in correct index location
                if (A[rightIndex] != A[i]){

                    //swap if they are not in correct location
                    int temp = A[i];
                    A[i] = A[rightIndex];
                    A[rightIndex] = temp;
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
