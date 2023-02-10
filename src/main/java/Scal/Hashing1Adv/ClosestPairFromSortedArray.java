package Scal.Hashing1Adv;

import java.util.Arrays;

public class ClosestPairFromSortedArray {
    private static int [] solve(int []A, int []B, int C){
        // 2 pointers where l points to 1st element array
        // r = last element in B array
        int l=0,r=B.length-1;
        int first =A[0];
        int second = B[B.length-1];
        int min = Math.abs(A[l]+B[r]-C);

        while ( l<A.length&& r >=0){
            int abs = Math.abs(A[l]+B[r] - C);

            if(abs == min && A[l] == first) {
                second= B[r];
            }

            if (abs<min) {
                min = abs;
                first = A[l];
                second = B[r];
            }
            if (A[l]+B[r] >=C) r--;
            else l++;
            }
        return new int [] { first, second};
    }
    public static void main(String[] args) {
        int [] A ={1, 2, 3, 4, 5};
        int [] B= {2,4,6,8};
        System.out.println(Arrays.toString(solve(A,B,9)));

        int [] AA ={5,10,20};
        int [] BB= {1,2,30};
        System.out.println(Arrays.toString(solve(AA,BB,13)));
    }
}
