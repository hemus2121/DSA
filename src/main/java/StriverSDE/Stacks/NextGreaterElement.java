package StriverSDE.Stacks;

import java.util.Stack;

/** Next Greater Element
 * Problem Statement: Given a circular integer array A, return the next greater element for every element in A. The next greater element for an element x is the first element greater than x that we come across while traversing the array in a clockwise manner.
 * If it doesn’t exist, return -1 for this element.
 */
public class NextGreaterElement {
    private static int [] getNextGreaterElement(int [] nums){

        int n = nums .length;
        Stack <Integer> st = new Stack<>();
        int [] nge = new int[n];

        // iterate for elements in input array from RIGHT side
        //size is 2n since we r thinkng of copying same array elements to as it is on right side
        for (int i = 2*n-1;i>=0;i--){
            //check for any less element in stack and remove them
            while (!st.isEmpty() && st.peek() <= nums[i%n]){
                st.pop();
            }
            if (i <n){
                if ( !st.isEmpty()){
                    nge[i] = st.peek();
                }
                else nge[i] =-1;
            }

            //add the current element to stack - modulo of %n - since rotation in array has to be done
            st.push(nums[i%n]);
        }
        return nge;
    }
    public static void main(String[] args) {
        int arr[]={5,7,1,2,6,0};

        int arr2[] = getNextGreaterElement(arr);
        System.out.println("The next greater elements are "); // expected 7 -1 2 6 7 5
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
