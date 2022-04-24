package LeetCode.Gen.Arrays;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/* Sliding Window Maximum
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
*/

//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {

    static  int [] getSlidingWindowMax (int []A, int k){

        //Sliding Window Maximum and Dequeue - TC: O(N) | SC: O(N)

        Deque<Integer> deque = new LinkedList<>();
        int [] resultArray = new int [A.length-k+1];
        int resultIndex=0;

        //SLIDE for 1st window
        for (int i=0;i< k;i++){

            //check whether incoming element is maximum than existing maximum if yes remove from Deque
            while (!deque.isEmpty() && deque.getLast() < A[i]){
                deque.removeLast();
            }
                 deque.add(A[i]);//Add incoming element
        }
        resultArray[resultIndex++] = deque.getFirst();

        //SLIDE for next window onwards
        for (int i =1;i<= A.length-k;i++){
            int outgoing = A[i-1];
            int incoming = A[i+k-1];

            //check whether incoming element is maximum than existing maximum if yes remove from Deque
            while (!deque.isEmpty() && deque.getLast() < incoming){
                deque.removeLast();
            }

            deque.addLast(incoming);

            //check if outgoing element = max element present first at Deque if YES- remove it
            if (deque.getFirst() == outgoing){
                deque.removeFirst();
            }

            //Add max element present at First
            resultArray[resultIndex++] = deque.getFirst();
        }
        return  resultArray;
    }

    public static void main(String[] args) {
        int [] data = { 1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(getSlidingWindowMax( data, 3)));
    }
}
