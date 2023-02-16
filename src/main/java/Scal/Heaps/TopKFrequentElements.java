package Scal.Heaps;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * https://leetcode.com/problems/top-k-frequent-elements/discuss/350472/Easy-and-Simple-Java-Solution-for-Interviews-Heap-%2B-HashMap
 */

import java.util.*;

/**
Algorithm Steps:

        1. Create a frequency table
        2. Create a Max Heap and add all the distinct elements
        3. Poll top k frequent elements off the Heap
     N = # of elements in the input array
     D = # of distinct (unique) elements in the input array
    Total Time Complexity = O(K log D)
    Total Space Complexity = O(D), this is the size of the heap.
*/
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freMap = new HashMap<>();
        for (int num : nums){
            freMap.put(num, freMap.getOrDefault(num, 0)+1);
        }
        //init heap 'the high frequent element first'
        Queue <Integer> heap= new PriorityQueue<>( (a, b) -> freMap.get(b)- freMap.get(a));
        for (int key : freMap.keySet()){
            heap.add(key);
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i =0;i <=k;i++){
            resultList.add(heap.poll());
        }
        return resultList;
    }


}
