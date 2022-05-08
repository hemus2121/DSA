package LeetCode.Arrays;

import java.util.*;

/* Intersection of Two Arrays II - https://leetcode.com/problems/intersection-of-two-arrays-ii/
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
*/

public class IntersectionOf2Arrays {
    private static int [] intersect (int [] nums1, int [] nums2){

        List<Integer> resultList = new ArrayList();
        int len1 = nums1.length;
        int len2 = nums2.length;

        int [] ref = len1 >len2? nums1: nums2;

        //Iterate and put longest  into map
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i : ref){
            if (freqMap.containsKey(i)){
                freqMap.put(i, freqMap.get(i)+1);
            }else freqMap.put(i, 1);
        }

        ref = (ref ==nums1)? nums2:nums1;
        
        //lets iterate over shorter array
        for (int i : ref){
            if (freqMap.containsKey(i)){
                freqMap.put(i, freqMap.get(i)-1);
            }
            if (freqMap.containsKey(i) &&  freqMap.get(i)>=0){
                resultList.add(i);
            }
        }
        //convert list to array
        return resultList.stream().mapToInt(val ->val).toArray();
    }
    public static void main(String[] args) {
        int [] data1 = { 4, 9, 5};
        int [] data2 = { 9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(data1, data2)));

        int [] data3 = { 1,2,2,1};
        int [] data4 = { 2, 2 };
        System.out.println(Arrays.toString(intersect(data3, data4)));
    }
}
