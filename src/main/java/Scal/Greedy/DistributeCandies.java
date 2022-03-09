package Scal.Greedy;

/*
Problem Description

There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?
 */
public class DistributeCandies {
    public  static int distributeCandies(int [] A){
        int min = 0;
        int [] resultArray = new int [A.length];

       resultArray[0]=1;

       //traversing from Left to right comparing consecutive elements
        for (int i =1;i< A.length;i++){
            if (A[i]> A[i-1]) {
                resultArray[i] = resultArray[i-1]+1;
            }else {
                resultArray [i] = 1;
            }
        }

        //traversing from right to left compare with i-2 to i -1 element
        for (int i = A.length-2;i>=0;i--){
            if  (A[i] >A[i+1]){
                int temp  =  resultArray[i+1] +1;
                resultArray[i] = Math.max(temp, resultArray[i]);
            }
        }


        for (int a : resultArray){
            min = min+ a;
        }
        return min;
    }
    public static void main(String[] args) {
        int []A = { 1,5,2,1};
        System.out.println(distributeCandies(A));
    }
}
