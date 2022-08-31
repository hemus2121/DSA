package Scal.Arrays.ArraysDynamicArrays;

import java.util.ArrayList;
import java.util.Arrays;

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

   static public String[] fizzNOrBuzzOPt01(int A) {
        String[] fizzBuzz = new String[A];
        for(int i = 0, j = i+1; i < A; i++, j++) {
            if(j%3 == 0 && j%5 == 0) fizzBuzz[i] = "FizzBuzz";
            else if(j%3 == 0) fizzBuzz[i] = "Fizz";
            else if(j%5 == 0) fizzBuzz[i] = "Buzz";
            else fizzBuzz[i] = String.valueOf(j);
        }
        return fizzBuzz;
    }

    static public String[] fizzNOrBuzzOPt1(int A) {
        int cnt3 = 0, cnt5 = 0;
        String[] fizzBuzz = new String[A];
        StringBuilder d;
        for(int i = 0, j = i+1; i < A; i++, j++) {
            d = new StringBuilder();
            cnt3++;
            cnt5++;
            if(cnt3 != 3 && cnt5 != 5) d.append(j);
            if(cnt3 == 3) {
                cnt3 = 0;
                d.append("Fizz");
            }
            if(cnt5 == 5) {
                cnt5 = 0;
                d.append("Buzz");
            }

            fizzBuzz[i] = d.toString();
        }

        return fizzBuzz;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fizzNOrBuzzOPt01(15)));
    }


}