package Scal.Recursion;

/*Problem Description

        The gray code is a binary numeral system where two successive values differ in only one bit.
        Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.
        A gray code sequence must begin with 0.
        */

import java.util.ArrayList;

public class Greycode {

    static int num=0;
    public static ArrayList<Integer> grayCode(int a) {
          ArrayList<Integer> res = new ArrayList<>();
          computeGreyCode(a, res);
          return res;
    }

    private static void computeGreyCode(int a,ArrayList<Integer>res){
        if (a==0) {
            res.add(num);
            return;
        }
        computeGreyCode(a-1, res);
        num = num ^ (1<<(a-1));
        computeGreyCode(a-1, res);
    }
    public static void main(String[] args) {
        System.out.println(grayCode(2));

    }
}
