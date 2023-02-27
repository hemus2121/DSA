package Scal.Hashing;

import java.util.*;

/*Problem Description
For Given Number A find if its COLORFUL number or not.
If number A is a COLORFUL number return 1 else return 0.

What is a COLORFUL Number:
A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.
 */
public class ColorfulNumber {
    private static int checkcolorful(int A) {

            //Generate individual number to get product
            List<Integer> dataList = new ArrayList();
            while (A > 0) {
                dataList.add(A % 10);
                A = A / 10;
            }

            //Iterate over each element in list computing product
            // and storing in set to check duplicates
            Set<Long> productSet = new HashSet();
            for (int i = 0; i < dataList.size(); i++) {
                long prod = 1;
                for (int j = i; j < dataList.size(); j++) {
                    prod = prod * dataList.get(j);
                    //already found
                    if (productSet.contains(prod)) return 0;
                    else productSet.add(prod);
                }
            }
            return 1;
        }

    public static void main(String[] args) {
       // System.out.println(checkcolorful(3245));
        //System.out.println(checkcolorful(32));
       // System.out.println(checkcolorful(326));
        System.out.println(checkcolorful(263));
    }
}
