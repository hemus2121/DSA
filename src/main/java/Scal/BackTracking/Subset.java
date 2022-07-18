package Scal.BackTracking;

import java.util.ArrayList;
import java.util.Collections;

/** Subset
 * Problem Description
 *
 * Given a set of distinct integers A, return all possible subsets.
 *
 * NOTE:
 *
 *     Elements in a subset must be in non-descending order.
 *     The solution set must not contain duplicate subsets.
 *     Also, the subsets should be sorted in ascending ( lexicographic ) order.
 *     The list is not necessarily sorted. 
 */

public class Subset {

    static ArrayList <ArrayList<Integer>> finalList = new ArrayList();

    public static  ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        // since values are needed in lexo order
        Collections.sort(A);
        computeSubSets(0,A, new ArrayList());
        return finalList;
    }
    public static void computeSubSets(int index, ArrayList <Integer> A, ArrayList <Integer> tempList ){

        finalList.add(new ArrayList(tempList));

        for (int i =index;i<A.size();i++){
            //DO - Add element to tempList
            tempList.add(A.get(i));
            //Recursive Call
            computeSubSets(i+1, A, tempList);

            // UNDO - remove the added element
            tempList.remove(tempList.size()-1);
        }
    }
    public static void main(String[] args) {
        ArrayList <Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        System.out.println(subsets(data));
    }
}
