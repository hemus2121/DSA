package Scal.Arrays;
/*
Find if two rectangles overlap
Problem Description
Eight integers A, B, C, D, E, F, G, and H represent two rectangles in a 2D plane.

For the first rectangle, its bottom left corner is (A, B), and the top right corner is (C, D), and for the second rectangle, its bottom left corner is (E, F), and the top right corner is (G, H).
Find and return whether the two rectangles overlap or not.
 */
public class RectanglesOverLap {
    public static int checkOverLap(int A, int B, int C, int D, int E, int F, int G, int H) {
        //based on coordinates of rectangles checking if they DONT overlap otherwise return 1
        // 1st is left of 2nd
        // 1st is right of 2nd
        // 1st is down of 2nd
        // 1st is up of 2nd
        if ( C <=E || A>=G || D<= F || B>= H){
            return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        int year =2020;
        int val = (year%400) & (year%4 ) & (year%100);
        System.out.println(val);
       // System.out.println(2020%4);
        //System.out.println(2020%100);
        System.out.println(checkOverLap(0,0, 4,4,2,2,6, 6)); //expected 1
    }
}
