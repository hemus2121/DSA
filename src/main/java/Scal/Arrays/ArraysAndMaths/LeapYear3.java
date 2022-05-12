package Scal.Arrays.ArraysAndMaths;
/* Leap Year -3
Problem Description
Given an integer A representing a year, Return 1 if it is a leap year else, return 0.

    Leap Year  if year is multiple of 400. Else year is multiple of 4 and not multiple of 100.
 */
public class LeapYear3 {
    private static int checkLeapYear(int number){
        return  ( number%400 == 0 ||  number%4 ==0 && number%100 != 0) ? 1 :0;
        //return 0;
    }
    public static void main(String[] args) {
        System.out.println(checkLeapYear(2020));
        System.out.println(checkLeapYear(1999));
    }
}
