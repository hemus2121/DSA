package Scal.Arrays;

import java.util.Arrays;
/*
Beggers outside

There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple,
 they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to their faith and ability)
 to some K beggars sitting next to each other.

Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day,
provided they don't fill their pots by any other means.
For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, Given by the 2D array B
 */

public class BeggersOutside {
    private static int [] computeAmount(int A, int [] [] B){
        int [] result = new int [A];

        //iterate over b Queries
        for (int i =0;i <B.length;i++){
            int start = B[i][0]-1; //array index is 0 based so get actual starting index
            int end = B[i][1]; // anyway we need to substract from R+1 query index so no need to reduce
            int amount = B[i][2];  // contribution amount


            result [start]+= amount;  //add to start index
            if (end < A){
                result [end] -=amount; // reduce from ending index if index is below array length
            }
        }

        //compute PF value, update in result array to avoid extra space of new Array creation
        int s = result[0];
        for (int i =1;i<A;i++){
            s += result[i];
            result [i] = s; //put the prefix sum in array itself
        }
        return result;
    }
    public static void main(String[] args) {
        int [][] B = {
                {1,2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };
        System.out.println(Arrays.toString(computeAmount(5, B)));
    }
}
