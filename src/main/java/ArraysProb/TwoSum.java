package ArraysProb;

import java.util.*;


public class TwoSum {

    /*
   Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
   You may assume that each input would have exactly one solution, and you may not use the same element twice.
   You can return the answer in any order.
    */

    // TODO Soln1 - time O(n^2) | space O(1)
    public static int [] twoNumberSumUsingLoops( int [] data, int target){

        for (int i =0;i<data.length;i++){
             int firstNumber = data[i];
             // compare from 2nd number
            for (int j =i+1;j < data.length;j++){
                 if (target == firstNumber + data[j]){
                     return new int [] {firstNumber, data[j]};
                 }
            }
        }
        return new int[0];
    }

    // TODO Soln2 -using maps - time - O(n) | space - O(n)
    public static int[] twoNumberSumUsingMap(int []data, int target){
        Map<Integer, Integer> dataMap = new HashMap<>();
         for (int i =0;i< data.length; i++){
             if (dataMap.containsKey(target-data[i])){
                 return new int [] {data[dataMap.get(target-data[i])], data[i]};
             } else {
                 dataMap.put(data[i], i);
             }
         }
        return new int [0];
    }

    //TODO Soln3 -using set - time - O(n) | space - O(n)
    public static int [] twoNumberSumUsingSet(int [] data, int target){

         Set<Integer> dataset = new HashSet<>();
         for (int i =0;i < data.length;i++){
             if (dataset.contains(target-data[i])){
                 return new int[]{target-data[i], data[i]};
             }else {
                 dataset.add(data[i]);
             }
         }
         return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoNumberSumUsingLoops(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10)));
        System.out.println(Arrays.toString(twoNumberSumUsingMap(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10)));
        System.out.println(Arrays.toString(twoNumberSumUsingSet(new int[] {3, 5, 4, 8, 11, 1, -1, 6}, 10)));
    }
}
