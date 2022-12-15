package StriverSDE.LinkedListArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Three Sum :Find triplets that add up to a zero
 *Problem Statement: Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero.
 * In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i, and their sum is equal to zero.
 * TC: O(N^2)
 * SC: (3*K) // k is the no.of triplets
 */
public class ThreeSum {
    private  static List <List< Integer >> threeSum(int[] num) {

        List<List<Integer>> resList = new ArrayList<>();
        //CRITICAL STEP
        Arrays.sort(num);

        for (int i =0;i< num.length-2;i++){
            // this will take care of handling duplicates at starting index
            if (i == 0 || (i > 0) && num[i-1]!= num[i]) {

                int low = i+1, high = num.length-1, target = 0-num[i];

                while(low <high){
                    if (num[low] + num[high] == target){
                        resList.add(Arrays.asList(num[i], num[low], num[high]));

                        // skip duplicates at lower end
                        while (low <high && num[low]==num[low+1]) low++;
                        while (low <high && num[high]==num[high-1]) high--;
                        low++;
                        high--;
                    }else if (num[low] + num[high] < target) low++;
                    else  high--;
                }
            }
        }
        return resList;
    }
    public static void main(String[] args) {
        int [] data ={-1,0, 1, 2, -1, -4};
        System.out.println( threeSum(data));
    }
}
