package StriverSDE.Stacks;
import java.util.Stack;

/** Largest Rectangle in Histogram
 *Problem Statement: Given an array of integers heights representing the histogram’s bar height where the width of each bar is 1  return the area of the largest rectangle in histogram.
 * Time Complexity: O( N )
 * * Space Complexity: O(3N) where 3 is for the stack, left small array and a right small array
 */
public class LargestRectangleYnHistogram {
    public static int largestRectArea(int [] heights){
        // using left smaller and right smaller approaches - SEMI optimized
        int [] leftSmaller = getLeftSmaller(heights);
        int [] rightSmaller = getRightSmaller(heights);

        long area =0;
        for (int i =0;i< heights.length;i++){
            area = Math.max(area, (rightSmaller[i]-leftSmaller[i]-1)*heights[i]);
        }
        return  (int)area;
    }
    private static int [] getLeftSmaller(int [] heights){
        Stack<Integer> st = new Stack<>();
        int [] leftSmaller = new int [heights.length];
        for (int i=0;i< heights.length;i++){
            //remove all higher elements
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if (!st.isEmpty()) leftSmaller[i] = st.peek();
            else leftSmaller[i] = -1;
            st.push(i);
        }
        return  leftSmaller;
    }

    private static int [] getRightSmaller(int [] heights){
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int [] rightSmaller = new int [n];
        for (int i=n-1;i>=0;i--){
            //remove all higher elements
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if (!st.isEmpty()) rightSmaller[i] = st.peek();
            else rightSmaller[i] = heights.length;
            st.push(i);
        }
        return  rightSmaller;
    }

    public static void main(String[] args) {
        int arr[] = {2, 4};
        System.out.println("The largest area in the histogram is " +
                largestRectArea(arr));
    }
}
