package Scal.Arrays;

/* Program to generate all SubArray of Array*/

// TC: O(n^3)
public class GenerateSubArray {
    private static void generateSubArray(int []A){
        int n = A.length;
        for (int i =0;i< n;i++){ // denote outloop
            for (int j =i;j< n;j++){  //denotes range
                // subarray will be between i -j now
                for (int k =i;k<= j;k++){ // iterate in between i - j elements
                    System.out.print(A[k]);
                }
                System.out.println("\t");
            }
        }
    }
    public static void main(String[] args) {
        int [] data = { 3, -2, 6, 4, 2};
        generateSubArray(data);
    }
}
