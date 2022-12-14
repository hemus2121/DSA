package Visa.Arrays;

public class MinMovesToEqualArrayElements {
    public int minMoves(int[] nums) {

        //Get the minimum element
        int min =Integer.MAX_VALUE;
        for(int num : nums){
            min = Math.min(min, num);
        }
        //Find different from number to minimum  element and increment count accordingly
        int moves = 0;
        for (int num : nums){
            moves+= min -num;
        }
        return moves;
    }
}
