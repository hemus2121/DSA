package Scal.TwoPointers;
/*
Problem Description

Given a sorted array of distinct integers A and an integer B, find and return how many rectangles with distinct configurations can be created using elements of this array as length and breadth whose area is lesser than B.
(Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)
 */
public class CountofRectangles {
    static int mod = (int ) Math.pow(10,9)+7;

    private static int countRectangles(int [] A, int B){
        // define 2 pointers left =0 and right =A.length-1
        int left=0, right=A.length-1, count=0;
        long area = 0;
        while(left <=A.length-1 && right>=0){
            area = 1l * A[left] * A[right];
            if (area < B){
                //number of elements upto B is right+1
                count = (count + right+1)%mod;
                left++;
            }else right--;
        }
        return count;
    }

    public static void main(String[] args) {
        int [] data = {1,2};
        System.out.println(countRectangles(data, 5));

        int [] data1 = {1,2, 4, 5};
        System.out.println(countRectangles(data1, 5));
    }
}
