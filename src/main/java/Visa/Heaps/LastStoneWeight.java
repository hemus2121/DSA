package Visa.Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
/** You are given an array of integers stones where stones[i] is the weight of the ith stone.

 We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 If x == y, both stones are destroyed, and
 If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 At the end of the game, there is at most one stone left.
 Return the weight of the last remaining stone. If there are no stones left, return 0.

 // https://leetcode.com/problems/last-stone-weight/
 */

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        //Using max heap
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        // add input elements
        for (int s : stones) {
            pq.add(s);
        }

        //iterate till pq size >1
        while (pq.size() > 1) {
            int s1 = pq.remove();
            int s2 = pq.remove();
            if (s1 != s2) {
                pq.add(s1 - s2);
            }
        }
        return pq.isEmpty() ? 0 : pq.size();
    }
}
