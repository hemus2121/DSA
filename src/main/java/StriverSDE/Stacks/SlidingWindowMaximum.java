package StriverSDE.Stacks;

import java.util.*;

/**  Sliding window maximum
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 */
public class SlidingWindowMaximum {

    private static int [] slidingwindowMax(int [] A, int B){
        Deque <Integer> dq = new LinkedList<>();
        List<Integer> resList = new ArrayList<>();

        // slide for 1st window of size B
        for (int i =0;i< B;i++){
            // keep of removing smaller elements
            while ( !dq.isEmpty() && dq.getLast()< A[i]){
                dq.removeLast();
            }
            dq.addLast(A[i]);
        }
        // push the result from front of Q to ans
        resList.add(dq.getFirst());

        for (int i = B;i< A.length;i++){
            while ( !dq.isEmpty() && dq.getLast()< A[i]){
                dq.removeLast();
            }
            dq.addLast(A[i]);

            //   remove if outgoing element (i-B) element is same as 1st element in deque
            if (dq.getFirst()==A[i-B] ){
                dq.removeFirst();
            }
            resList.add(dq.getFirst());
        }
        return resList.parallelStream().mapToInt(val->val).toArray();
    }
    public static void main(String[] args) {
        int i, j, n, k = 3, x;
        int arr[]={4,0,-1,3,5,3,6,8};
        int ans[] = slidingwindowMax(arr, k);
        System.out.println(Arrays.toString(ans)); //expected 4 3 5 5 6 8
    }
}
