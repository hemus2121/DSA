package Scal.Hashing.Assi;

import java.util.HashMap;
import java.util.Map;

/*

Shaggy has an array A consisting of N elements. We call a pair of distinct indices in
that array as a special pair if elements at that index in the array are equal.

Shaggy wants you to find a special pair such that distance between that pair is minimum.
Distance between two indices is defined as |i-j|.
If there is no special pair in the array then return -1.
 */
public class Shaggyanddistances {
    private static int getDistance(int []A){
        int ans = Integer.MAX_VALUE;
        //Placeholder for elements
        Map<Integer,Integer> dataMap = new HashMap();
        for (int i =0;i<A.length;i++){
            if(dataMap.containsKey(A[i])){
                ans = Math.min(ans, i-dataMap.get(A[i]));
                //replace with latest index
                dataMap.put(A[i],i);
                }else{
                //store element along with index if not found
                dataMap.put(A[i],i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] data = {7, 1, 3, 4, 1, 7};
        System.out.println(getDistance(data));

    }
}
