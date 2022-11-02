package visa.Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/last-stone-weight/
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
