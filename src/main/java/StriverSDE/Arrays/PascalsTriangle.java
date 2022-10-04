package StriverSDE.Arrays;

import java.util.ArrayList;
import java.util.List;

/** Pascals Triangle
 * https://www.codingninjas.com/codestudio/problems/1089580?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 */

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(); // to store final result
        List<Integer> row = null, previous = null;

        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) //handling case of 1st col and last col
                    row.add(1);
                else
                    row.add(previous.get(j - 1) + previous.get(j));
            }
            previous = row;
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
