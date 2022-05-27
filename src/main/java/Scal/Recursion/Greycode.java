package Scal.Recursion;

/**  Problem Description

        The gray code is a binary numeral system where two successive values differ in only one bit.
        Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.
        A gray code sequence must begin with 0. */

import java.util.ArrayList;

public class Greycode {

    public static ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (a == 0) return null;
        if (a == 1) {
            ans.add(0);
            ans.add(1);
            return ans;
        }
        ArrayList<Integer> codes = grayCode(a - 1);
        int x = codes.size();
        for (int i = 0; i < x; i++)
            ans.add(codes.get(i));

        for (int i = x - 1; i >= 0; i--)
            ans.add(codes.get(i) + (1 << (a - 1)));
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(grayCode(2)); //expected [0,1,3,2]
        System.out.println(grayCode(1)); //expected [0,1]
    }
}
