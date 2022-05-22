package LeetCode.Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/** Fruits Into Baskets -https://leetcode.com/problems/fruit-into-baskets/
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.

 */
public class FruitsIntoBaskets {
    private static int computeMaximumFruits(int [] fruits){
        int left =0;
        Map< Integer, Integer> freqMap = new HashMap<>();
        int MAXWINDOWSIZE = 2;
        int maxWindowSize=0;

        for (int right =0;right <fruits.length;right++){
            freqMap.put(fruits[right], freqMap.getOrDefault(fruits[right],0)+1);
            if (freqMap.size() > MAXWINDOWSIZE && left<=right){
                //outgoing element so reduce frequency
                freqMap.put(fruits[left], freqMap.get(fruits[left])-1);
                if ( freqMap.get(fruits[left])==0){
                    freqMap.remove(fruits[left]);
                }
                //increase left pointer
                left++;
            }
            maxWindowSize = Math.max( maxWindowSize, right-left+1 );
        }
        return maxWindowSize;
    }
    public static void main(String[] args) {
        int [] dat = {  1,2,3,2,2};
        System.out.println(computeMaximumFruits(dat)); //expected = 4

        int [] dat1 = {  0,1,2,2};
        System.out.println(computeMaximumFruits(dat1)); //expected = 3

    }
}
