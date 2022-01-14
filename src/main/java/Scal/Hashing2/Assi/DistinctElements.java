package Scal.Hashing2.Assi;

import java.util.*;

//https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
public class DistinctElements {
    private static int[] getDistcount(int []A, int B){
        Map<Integer, Integer> dataMap = new HashMap();
        List<Integer> res= new ArrayList<>();

        //1st window elements along with their frequency
        for (int i =0;i<B;i++){
            dataMap.put(A[i],dataMap.getOrDefault(A[i],0)+1);
        }
        // add mapsize to result
        res.add(dataMap.size());

        for (int i =B;i<A.length;i++) {
            //remove from map outgoing element count =1;
            if (dataMap.get(A[i - B]) == 1) dataMap.remove(A[i - B]);

                //reduce freqcount from map if frequency count is more than 1
            else dataMap.put(A[i], dataMap.get(A[i - B]) - 1);

            //add new incoming element  into map along with frequency
            dataMap.put(A[i], dataMap.getOrDefault(A[i], 0) + 1);
            res.add(dataMap.size());
        }
        //convert list into array and return
        return res.stream().mapToInt(val->val).toArray();
    }
    public static void main(String[] args) {
        int [] data=  {1,2,1,3,4,3};
        System.out.println(Arrays.toString(getDistcount(data,3)));

    }
}
