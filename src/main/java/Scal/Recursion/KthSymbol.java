package Scal.Recursion;

/** Kth Symbol
 * Problem Description
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * Given row A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.) (1 indexed).
 */
public class KthSymbol {
    private static int  getKthSymbol(int A, int B){
        return compute(A, B);
    }

    /*
    //1->         0
    //2->     0        1
    //3->  0    1    1    0
    //4-> 0 1  1 0  1 0  0 1
    //if we closely observe that half of nth row is same as n-1th row eg…for 4->0110 1001.
    //0110  this part is same as n-1th row that is 3–> 0110. so easily we can reduce the n part
    //to n-1 no big deal. But we have to reduce the k part wisely. Again from the observation
    //we can say if there is a mid position[0 1 1 0 | 1 0  0 1], then we can easily say that if
    //k<=mid the left part is exactly the n-1th row (solve(n-1,k). but the right half is exactly
    //the inverse of n-1th row [1 0  0 1]->! [0 1 1 0 ].
    //So we can return NOT of solve(n-1,k-mid)
     */
    static int compute(int n, int k){
        // base case
        if (n==0 || k==1) return 0;
        //main logic
        int totalLen = (int) Math.pow(2, n-2);
        //k is in 1st half which is equal of previous row
        if (k <= totalLen) return  compute(n-1,k);
        // k is in 2nd half which is NOT of previous row
        else return (1 - compute(n-1,k-totalLen));
    }
    public static void main(String[] args) {
        System.out.println(getKthSymbol(2, 1)); //expected 0
        System.out.println(getKthSymbol(2, 2)); //expected 1
    }
}
