package Scal.DynamicProg;

import java.util.*;

/**Minimum sum Path in Triangle
 *Problem Description
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * Adjacent numbers for jth number of row i is jth and (j+1)th numbers of row i+1 is
 */
public class MinSumPathInTriangle {

    //global variables
    static ArrayList<ArrayList<Integer>> triangle;
    static Map<String, Integer> dpMap = new HashMap<>();

    private static int compute(ArrayList<ArrayList<Integer>> triangle){
        triangle = triangle;
       // System.out.println("Recur:" + computeMinSumPathRecur(0,0) +  " Iterative:"+ computeMinSumIterative(A));;
        return computeMinSumIterative(triangle);
    }

    //Compute form top of triangle to bottom of triangle using recursion
    static int computeMinSumPathRecur(int row, int col){
        //base case
        String key = row + ":"+ col;
        if (dpMap.containsKey(key)) return dpMap.get(key);

        //compute
        int pathValue = triangle.get(row).get(col);
        if (row < triangle.size()-1){
            pathValue += Math.min(computeMinSumPathRecur(row+1, col), computeMinSumPathRecur(row+1, col+1));
        }
        dpMap.put(key, pathValue);
        return pathValue;
    }

    //Bottom up Approach
    // flip triangle upside down - Iterate up through each row index between n - 2 and 0 inclusive (where n is the number of rows in triangle):
    //Iterate through each col index between 0 and row inclusive:
    //Set smallestBelow to be the min out of triangle[row + 1][col] and triangle[row + 1][col + 1].
    //Set triangle[row][col] to be itself plus smallestBelow.
    //Return triangle[0][0]
    static int computeMinSumIterative(ArrayList<ArrayList<Integer>>A){

        for (int row = A.size()-2;row >=0;row --){

            for (int col =0;col <=row;col++){

                int belowVal =Math.min(A.get(row+1).get(col), A.get(row+1).get(col+1));
                A.get(row).set(col, belowVal+ A.get(row).get(col));
            }
        }
        return A.get(0).get(0);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> completeData = new ArrayList();
        ArrayList<Integer> data  = new ArrayList<>();
        data.add(2);
        ArrayList<Integer> data1 = new ArrayList<>();
        data1.add(3);
        data1.add(4);
        ArrayList<Integer> data2 = new ArrayList<>();
        data2.add(6);
        data2.add(5);
        data2.add(7);
        ArrayList<Integer> data3 = new ArrayList<>();
        data3.add(4);
        data3.add(1);
        data3.add(8);
        data3.add(3);
        completeData.add(data);
        completeData.add(data1);
        completeData.add(data2);
        completeData.add(data3);
        System.out.println(compute(completeData)); //expected 11
    }
}
