package Scal.BinarySearch;

import java.util.ArrayList;
import java.util.*;

public class Ponny {
    public static int [] check(int [] A, int []B){
        //create pf array
        int [] prfA = new int [A.length];
        prfA[0]= A[0];
        for (int i =1;i<=A.length-1;i++){
            prfA[i] = prfA[i-1]+ A[i];
        }
        List <Integer> res = new ArrayList<>();
        for (int i =0;i<=B.length-1;i++){
            res.add(bs(prfA, B[i]));
        }

        return res.stream().mapToInt(val -> val).toArray();
    }

    private static int bs(int [] prfA, int b){
        int r = prfA.length-1, l =0;
        int mid=0;
        int ans =0;
        while (l <=r ){
            mid = (l+ r)/2;
            if (prfA[mid]==b) return mid;
            else if (prfA[mid] <= b) {
                l = mid+1;
                ans=mid+1;
            }
            else r = mid-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        //int [] A= { 3,4, 4, 6};
        //int [] B = { 20,4, 10,2};
        //System.out.println(Arrays.toString(check(A, B)));
        int [] A= { 23,36, 58, 59};
        int [] B = { 3, 207, 62, 654, 939, 680, 760};
        System.out.println(Arrays.toString(check(A, B)));

    }
}
