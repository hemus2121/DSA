package StriverSDE.Stacks;

import java.util.Arrays;
import java.util.Stack;

/** Next Smaller element
 *  Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
 */
public class NextSmallerElement {

    public  static int[] getNextSmaller(int[] nums) {

        int n = nums.length;
        Stack <Integer> st = new Stack<>();
        int [] nse = new int [n];

        //pop out all larger or equal elements since we need smaller elements
        for (int i =0;i< n;i++){
             while (!st.isEmpty() && st.peek()>= nums[i]){
                st.pop();
             }

            //update to latest smallest element present on top of stack
             if (!st.isEmpty()) nse[i] = st.peek();
             //check if stack is empty update value to -1
             else nse[i] = -1;

             //push to stack incoming element coming in
             st.push(nums[i]);
        }
        return nse;
    }

    public static void main(String[] args) {
        int []  data = new int []{ 4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(getNextSmaller(data)));
    }
}
