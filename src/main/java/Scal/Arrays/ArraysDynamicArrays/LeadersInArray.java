package Scal.Arrays.ArraysDynamicArrays;

/*
Problem Description

Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
An element is a leader if it is strictly greater than all the elements to its right side.
NOTE:The rightmost element is always a leader.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeadersInArray {
    private static int [] getLeaders(int [] data){

        int n = data.length;
        // result List
        List<Integer> resultList = new ArrayList();

        //rightmost element is always leader
        int greaterElement = data[n-1];
        resultList.add( greaterElement);

        //iterate from right and maintain a right greater element till now
        for (int i = n-2;i>=0;i--){
            if ( data[i] > greaterElement){
                greaterElement = data[i];
                resultList.add(greaterElement);
            }
        }

        return resultList.stream().mapToInt(val->val).toArray();
    }

    public static void main(String[] args) {
        int [] data = { 16, 17, 4, 3, 5, 2};
        System.out.println(Arrays.toString(getLeaders(data)));
    }
}