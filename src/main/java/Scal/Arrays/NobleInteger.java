package Scal.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* Noble Integer
Problem Description
Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.

 */
public class NobleInteger {
    // TC: NLOGN -- sorting input array
    private static int getNobleInteger(ArrayList<Integer> A){

        Collections.sort(A);
        Collections.reverse(A);
        // case where input consists of 0 and negative numbers
         if(A.get(0)==0) return 1;

        for (int i =0;i< A.size();i++){
            //check where index == A[i] which indicates (0-> index length) greater elements are present than current element
            // 3 3 2 1
            if (i == A.get(i) && A.get(i)!=A.get(i-1)){
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList <Integer> dataList = new ArrayList<>(Arrays.asList(3,2,1,3));
        System.out.println(getNobleInteger(dataList));

        ArrayList <Integer> dataList1 = new ArrayList<>(Arrays.asList( -4, -2, 0, -1, -6));
        System.out.println(getNobleInteger(dataList1));
    }
}
