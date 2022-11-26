package Visa.Arrays;

import java.util.Arrays;

public class SortIntegersByNumbers {
    public static int[] sortByBits(int[] arr) {
        // Store array number and its bits in 2 D array
        int[][] cur = new int[arr.length][2];  ////[[0,0],[1,1],[2,1],[3,2],[4,1],[5,2]]
        for (int i=0;i< arr.length;i++){
            cur[i][0] = arr[i];
            cur[i][1] = Integer.bitCount(arr[i]); //get bit count based on inbuilt function
        }

        Arrays.sort(cur, (a,b)-> a[1]== b[1]? a[0]-b[0]: a[1]-b[1]);

       for (int i=0;i< arr.length;i++){
           arr[i]= cur[i][0];
       }
        return  arr;
    }

    public static void main(String[] args) {
        int [] data = {5,6,7,8};
        System.out.println(sortByBits(data));
    }
}
