package Scal.Arrays;
/*
Problem Description
Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
The digits are stored such that the most significant digit is at the head of the list.
NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :
    Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
    A: For the purpose of this question, YES
    Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
    A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Add1ToNumber {

    static int[] add1ToNumber(int []A){
        int [] res = addNumber(A);
        return  removeTrailingZeros(res);
    }

    // Need to remove starting zeros
     static int[] removeTrailingZeros(int[] res) {
         List<Integer> resList = new ArrayList<>();
         for (int i : res){
             if (i==0 && resList.size()==0){
                 continue;
             }
             resList.add(i);
         }
         return resList.stream().mapToInt(val->val).toArray();
    }

    //Method to add 1 from  LSB side
    static int [] addNumber(int []A){
        //iterate from LSB and check if its <9 if yes add 1 to whole number
        for (int i = A.length-1;i>=0;i--){
            if (A[i]<9){
                A[i]++;
                return A;
            }
            // set value to zero if value at that location is more than 9
            A[i]=0;
        }
        //result
        int [] result = new int[A.length+1];
        result[0]=1;
        return result;
    }

    public static void main(String[] args) {
        int [] data = {9,9,9,4,9};
        System.out.println(Arrays.toString(add1ToNumber(data)));
    }
}
