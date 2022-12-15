package Scal.BinarySearch;

public class AthMagicalNumber {
    private static  int getMagicalNumber(int A, int B , int C){
        int mod = (int) Math.pow(10,9)+7;
        //search space
        long l = Math.min(B,C);
        long r = A*1L*Math.min(B,C);
        long lcm = (long) B*C/getGCD(B,C);
        long ans =0;
        //normal binary search
        while(l<=r){
            long mid = (l+r)/2;
            long cntB= mid/B, cntC=mid/C, cntBC= mid/lcm;
            long temp = cntB + cntC - cntBC;

            if (temp == A){
                // mid might one one solution but we shall try better one also
                ans = mid % mod;
                l = mid-1;
            }
            if (temp <A) l = mid+1;
            else r = mid-1;
        }
        return (int)(ans);
    }

    private static int getGCD(int a, int b){
        if (b == 0) return a;
        return getGCD(b, b%a);
    }

    public static void main(String[] args) {
        System.out.println(getMagicalNumber(1,2,3));
    }
}
