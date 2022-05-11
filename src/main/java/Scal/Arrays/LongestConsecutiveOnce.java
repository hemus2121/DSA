package Scal.Arrays;
/*
Length of longest consecutive ones

Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
 Find and return the length of the longest consecutive 1’s that can be achieved.
 */

public class LongestConsecutiveOnce {

    public static int getTotalOnce(String A) {
        int n = A.length();
        int[] leftPref1s = new int[n]; // to store number of 1's on left side of 0th value index
        int[] rightPref1s = new int[n]; // to store number of 1's on right side of 0th value index
        int countOf1s = 0;

        // calculating total count of 1's
        for(int i = 0; i < n; i++){
            if(A.charAt(i)-'0' == 1)
                countOf1s++;
        }

        // if all are 1's then we can't swap any more and answer is same as n
        if(n == countOf1s) return countOf1s;

        // left prefix
        leftPref1s[0] = A.charAt(0)-'0'; // 0th index
        for(int i = 1; i < n; i++){ // remaining elements
            if(A.charAt(i)-'0' == 0)
                leftPref1s[i] = 0;
            else
                leftPref1s[i]  = leftPref1s[i-1] +1;
        }

        // right prefix
        rightPref1s [n-1] = A.charAt(n-1)-'0'; //nth index
        for(int i = n-2; i >= 0; i--){  // remaining elements
            if(A.charAt(i)-'0' == 0)
                rightPref1s[i] = 0;
            else
                rightPref1s[i]  = rightPref1s[i+1] +1;
        }

        //Final computation
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(A.charAt(i)-'0' == 0){
                int L=0, R=0;
                if (i >0) L= leftPref1s[i-1];
                if (i<n-1) R = rightPref1s[i+1];
                // to handle the case where no of L+R 1's count is same as countOf1s

                if(L+R < countOf1s)
                    ans = Math.max(ans, L+R+1);
                else
                    ans = Math.max(ans, L+R);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getTotalOnce("111000")); // expected 3
        System.out.println(getTotalOnce("100100111101")); //expected 6
    }
}