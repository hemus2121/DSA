package LeetCode.Arrays;

/**
 * There are N holes arranged in a row in the top of an old table. We want to fix the table by covering the holes with two boards. For technical reasons, the boards need to be of the same length.
 * The position of the K-th hole is A[K]. What is the shortest length of the boards required to cover all the holes? The length of the boards has to be a positive integer. A board of length L, set at position X, covers all the holes located between positions X and X+L (inclusive). The position of every hole is unique.
 * Write a function:
 *     class Solution { public int solution(int[] A); }
 * which, given an array A of integers of length N, representing the positions of the holes in the table, returns the shortest board length required to cover all the holes.
 *
 * Examples:
 * 1. Given A = [11, 20, 15], your function should return 4. The first board would cover the holes in positions 11 and 15, and the second board the hole at position 20.
 * 2. Given A = [15, 20, 9, 11], your function should return 5. The first board covers the holes at positions 9 and 11, and the second one the holes in positions 15 and 20.
 * 3. Given A = [0, 44, 32, 30, 42, 18, 34, 16, 35], your function should return 18. The first board would cover the holes in positions between 0 and 18, and the second the positions between 30 and 44.
 * 4. Given A = [9], your function should return 1.
 * Write an efficient algorithm for the following assumptions:
 *
 *         N is an integer within the range [1..100,000];
 *         each element of array A is an integer within the range [0..1,000,000,000];
 *         the elements of A are all distinct..
 */
public class HolesProblem {
    public static int findMinLength(int[] holes){
        if (holes.length <=2) return 1;

        int minHole = Integer.MAX_VALUE;
        int maxHole = Integer.MIN_VALUE;

        // get min and max values
        for (int hole : holes){
            minHole = Math.min(minHole, hole);
            maxHole = Math.max(maxHole, hole);
        }

        int mid = minHole + (maxHole-minHole)/2;
        int closestMinToMid = minHole;
        int closestMaxToMid = maxHole;

        for (int hole : holes){
            if (hole<= mid){
                closestMinToMid = Math.max(closestMinToMid, hole);
            }
            if (hole > mid){
                closestMaxToMid = Math.min(closestMaxToMid, hole);
            }
        }
        return Math.max(closestMinToMid- minHole, maxHole- closestMaxToMid);
    }

    public static void main(String[] args) {
        int [] data = {11, 20, 15};
        System.out.println(findMinLength( data));
        int [] data1 = {15, 20, 9, 11};
        System.out.println(findMinLength( data1));
        int [] data2 = {0, 44, 32, 30, 42, 18, 34, 16, 35};
        System.out.println(findMinLength( data2));
    }
}
