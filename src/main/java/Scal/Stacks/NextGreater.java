package Scal.Stacks;

import java.util.Arrays;
import java.util.Stack;

/* Problem Description

  Given an array A, find the next greater element G[i] for every element A[i] in the array.
  The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array, A.

    More formally:

    G[i] for an element A[i] = an element A[j] such that
    j is minimum possible AND
    j > i AND
    A[j] > A[i]

Elements for which no greater element exists, consider the next greater element as -1.
 */
public class NextGreater {
    private static int [] nextGreaterElements(int []A){
        int [] res = new int [A.length];
        Stack<Integer> st = new Stack<>();
        for (int i =A.length-1;i>-1;i--){
            //while top element is less than keep poping - we need higher element
            while (!st.isEmpty() && st.peek() <=A[i]){
                st.pop();
            }
            if (st.isEmpty()) res[i]=-1;
            else res[i]= st.peek();

            st.push(A[i]);
        }
        return  res;
    }
    public static void main(String[] args) {
        int [] data = {4, 5, 2, 10};
        System.out.println(Arrays.toString(nextGreaterElements(data)));
    }
}
