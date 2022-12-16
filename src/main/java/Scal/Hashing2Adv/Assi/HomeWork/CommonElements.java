package Scal.Hashing2Adv.Assi.HomeWork;

import java.util.*;
/*
Problem Description

Given two integer array A and B of size N and M respectively.
Your task is to find all the common elements in both the array.
 */
public class CommonElements {
    private static int [] commonElements(int [] A , int [] B){
        //creat a map of 1st
        Map<Integer,Integer> aMap= new HashMap();
        for (int a : A){
            aMap.put(a, aMap.getOrDefault(a,0)+1);
        }

        List<Integer> result = new ArrayList<>();
        for (int b : B) {
            if (aMap.containsKey(b) && aMap.get(b)>0){
                result.add(b);
                aMap.put(b, aMap.get(b)-1);
            }
        }
        System.out.println(result);
        return result.stream().mapToInt(val->val).toArray();

 //       // map for 2nd array
 //       Map<Integer,Integer> bMap = new HashMap();
  //      for (int b : B ){
  //          bMap.put(b, bMap.getOrDefault(b,0)+1);
   //     }

//        //iterate over key elements in 1st hahmap and get common elements from
//        //2nd and get minimum of both number
//        Map<Integer, Integer> res = new HashMap();
//        for (Map.Entry<Integer,Integer> entry: aMap.entrySet()){
//            int key = entry.getKey();
//            if (bMap.containsKey(key)){
//                int minValue = Math.min(entry.getValue(),bMap.get(key));
//                res.put(key, minValue);
//            }
//        }
//
//        //now build result from result map
//        List <Integer> resList = new ArrayList();
//        for (Map.Entry<Integer,Integer> entry : res.entrySet()){
//            int key = entry.getKey();
//            int value = entry.getValue();
//            for (int i =0;i<value;i++){
//                resList.add(key);
//            }
//        }
//        return resList.stream().mapToInt(val->val).toArray();
    }
    public static void main(String[] args) {
        int [] A= {1, 2, 2, 1};
        int [] B = {2,3,1,2};
        System.out.println(Arrays.toString(commonElements(A, B)));
    }
}
