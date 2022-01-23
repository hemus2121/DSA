package Scal.Contest1;

import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

/* problem statement
Array of N elements, asked to perform q queries on array , In ith operation, replace all occurrences of
B[i][0] with some B[i][1]
1<=N, Q <= 2 *10~5
1 <= A[i], B[i][0], B[i][1] <=50
 */
public class ReplaceArray {
    private static int [] print2d(int [][] A, int[] B){
        int max =Integer.MIN_VALUE;
        for (int b:B){
            if (b> max){
                max =b;
            }
        }
       //construct map for maximum number of elements present in ref array
        Map<Integer,Integer> myMap = new HashMap<>();
        for (int i=1;i<=max;i++){
            myMap.put(i,i);
        }

        for (int i =0;i< A.length;i++){
                int val = A[i][0];
                int val1 = A[i][1];
                List<Integer> values = myMap.values().stream().collect(Collectors.toList());

                for (int ii=0;ii<values.size();ii++){
                    if (values.get(ii)==val){
                        values.set(ii,val1);
                    }
                }
                //put back the values into map
                int index=0;
                for (Map.Entry<Integer,Integer> entry : myMap.entrySet()) {
                   entry.setValue(values.get(index++));
                }
           }

        //iter over input array
         for (int i =0;i< B.length;i++){
             if (myMap.containsKey(B[i])){
                 B[i] = myMap.get(B[i]);
             }
        }
        return B;
    }

    public static void main(String[] args) {
        int [][] A= {
                {3,2},
                {5,5},
                {2,4},
                {3,2},
                {5,2}
        };
        int [] B = {2,2,5,1};
        System.out.println(Arrays.toString(print2d(A,B)));
    }
}
