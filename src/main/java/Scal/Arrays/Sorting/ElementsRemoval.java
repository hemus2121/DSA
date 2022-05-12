package Scal.Arrays.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Elements Removal
Problem Description

Given an integer array A of size N. You can remove any element from the array in one operation.
The cost of this operation is the sum of all elements in the array present before this operation.

Find the minimum cost to remove all elements from the array.
 */
public class ElementsRemoval {
    private static int sumOfElements(List<Integer> A){
        int cost=0;
        Collections.sort(A, Collections.reverseOrder());
        for (int i =0;i< A.size();i++){
            cost = cost + A.get(i)*(i+1);
        }
        return cost;
    }
    public static void main(String[] args) {
        List<Integer> dataList = new ArrayList<>(Arrays.asList(2,1));
        System.out.println(sumOfElements(dataList)); //expected 4
    }
}
