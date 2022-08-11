package Scal.Arrays.ArraysDynamicArrays;

import java.util.ArrayList;

/* Problem Description
Given a positive integer A, return an array of strings with all the integers from 1 to N.
But for multiples of 3 the array should have “Fizz” instead of the number. For the multiples of 5, the array should have “Buzz” instead of the number.
For numbers which are multiple of 3 and 5 both, the array should have "FizzBuzz" instead of the number.
 */
public class FizzBuzz {
    private static ArrayList<String> fizzbuzz(int A) {

        ArrayList<String> resList = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            // this is very important to check at first
            if (i % 3 == 0 && i % 5 == 0) resList.add("FizzBuzz");
            else if (i % 5 == 0) resList.add("Buzz");
            else if (i % 3 == 0) resList.add("Fizz");
            else resList.add("" + i);
        }
        return resList;
    }

    public static void main(String[] args) {
        System.out.println(fizzbuzz(15));
    }


}