package Scal.Arrays.PFSumCarryForward;

/* XOR Queries
Problem Description
You are given an array A (containing only 0 and 1) as element of N length.

Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array.
 */

public class XORQueries {
    public static int [][] computeValues(int [] A, int [][]B){

        int[][] outputArray = new int[B.length][B[0].length];

        int [] xorPFArray = new int [A.length];
        xorPFArray[0] = A[0];

        ///Pf XOR array of elements
        for (int i =1;i< A.length;i++){
            xorPFArray[i] = xorPFArray[i-1]^ A[i];
        }

        //System.out.println("XOR PF ARray"+ Arrays.toString(xorPFArray));

        int [] zeroPFArray = new int [A.length];
        if (A[0]==0) zeroPFArray[0]=1; //otherwise its zero by default
        for (int i=1;i< A.length;i++){
            if (A[i]==0) {
                zeroPFArray[i] = zeroPFArray[i-1]+1;
            }else {
                zeroPFArray[i] = zeroPFArray[i-1];
            }
        }
       //System.out.println("zero PF ARray"+ Arrays.toString(zeroPFArray));

        for (int i = 0; i < B.length; i++) {
            int l = B[i][0]-1;
            int r = B[i][1]-1;

            int xoroutput = (l==0)? xorPFArray[r] :  xorPFArray[r]^ xorPFArray[l-1];
            int zerooutput = (l==0)? zeroPFArray[r]: zeroPFArray[r]- zeroPFArray[l-1];

            outputArray[i][0] = xoroutput;
            outputArray[i][1] = zerooutput;
        }
        return outputArray;

    }
    public static void main(String[] args) {
        int [] A = {1,0,0,0,1};
        int [][] B = {
                {2,4},
                {1,5},
                {3,5}
        };
        System.out.println(computeValues(A,B));
    }
}
