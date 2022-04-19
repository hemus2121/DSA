package Scal.Arrays;
/* Problem Description
Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.

Problem Constraints
1 <= A.size() <= 104
1 <= A[i] <= 109
1 <= B <= 109
 */

// TC :O(n2) SC: O(1)
public class GoodPair {
    private static int solve (int []A, int B){
        for (int i=0;i< A.length;i++){
            for (int j =i+1;j<A.length;j++)
                if (A[i]+ A[j]==B) return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int [] A = { 1, 2, 3, 4};
        System.out.println(solve(A, 7));

        int [] AA = { 1, 2, 4};
        System.out.println(solve(AA, 4));
    }
}
