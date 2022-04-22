package Scal.Arrays;

import java.util.Arrays;

public class CheckAP {
    private static int checkAP(int [] A){
        //sort the array to keep numbers in order
        Arrays.sort(A);
        //compute init diff
        int diff = A[1]-A[0];

        //iterate over array elements if difference is same than its AP otherwise not
        for (int i=1;i<=A.length-1;i++){
            if (A[i]-A[i-1]!=diff) return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        int [] data = { 3, 5, 1};
        System.out.println(checkAP(data));

        int [] data1 = { 2, 4, 1};
        System.out.println(checkAP(data1));
    }
}
