package Scal.StringMatching.Assi;

import java.util.Arrays;

/*
Given two binary strings A and B, count how many cyclic permutations of B when taken XOR with A give 0.

NOTE: If there is a string, S0, S1, ... Sn-1 , then it's cyclic permutation is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1
where k can be any integer from 0 to N-1.
 */
public class CyclicPermutation {
//    private static int getPermut(String A, String B){
//        B = B+B;
//        String str = A+'$'+B.substring(0, B.length()-1);
//        int n = str.length();
//        int[] Z = new int[n];
//
//
//        Zstring(Z, str, n);
//        System.out.println("hiss::input::"+str + " Zarray::"+Arrays.toString(Z));
//
//        int count = 0;
//        for(int i=A.length()+1; i<n; i++)
//        {
//            if(Z[i] == A.length())
//                count++;
//        }
//        return count;
//    }
//
//    private static void Zstring(int[]Z,String str, int n){
//        {
//            int left = 0, right = 0;
//            for(int i=1; i<n; i++)
//            {
//                if(i > right)
//                {
//                    left = right = i;
//
//                    while(right < n && str.charAt(right) == str.charAt(right-left))
//                        right++;
//                    Z[i] = right-left;
//                    right--;
//                }
//                else
//                {
//                    if(Z[i-left] < right-i+1)
//                        Z[i] = Z[i-left];
//                    else
//                    {
//                        left = i;
//
//                        while(right < n && str.charAt(right) == str.charAt(right-left))
//                            right++;
//                        Z[i] = right-left;
//                        right--;
//                    }
//                }
//            }
//        }
//    }
    private static int getPermutationCount(String A,String B){
        //A is reference String and B is input string
       // String str = A.concat("$").concat(B).concat(B);

        B = B+B;
        String str = A+'$'+B.substring(0, B.length()-1);

        //Z array definition
        int Z[] = new int [str.length()];
      
        // ZAlgorigthm
        zAlgoImplement(str,Z);
        System.out.println("mine::::input::"+str + " Zarray::"+Arrays.toString(Z));
        int reqLen= A.length();
        int countofreqLen=0;
        for (int z : Z){
            if (z==reqLen){
                countofreqLen++;
            }
        }
        return countofreqLen;
    }

    private static void zAlgoImplement(String s, int [] Z){
        int l =0,r=0;
        for (int i=1;i<s.length();i++){
            // case of outside segment (region) - apply bf
            if (i>r){
                l=i;r=i;
                while(r <s.length() && (s.charAt(r)==s.charAt(r-l)) ){
                    r++;
                }
                Z[i]=r-l;
                r--;
            }else {
                // copy section
                int j = (i-l);
                if(Z[j]<r-i+1){
                    Z[i] =Z[j];
                }else{
                    //again apply BF for the boundary touching or crossing boundary
                    l=i;
                    //r++;
                    while (r<s.length() && s.charAt(r)== s.charAt(r-l)){
                        r++;
                    }
                    Z[i]=r-l;
                    r--;
                }
            }
        }
    }


    public static void main(String[] args) {

        //System.out.println(getPermutationCount(A,B));
        System.out.println(getPermutationCount("1001","0011"));
       // System.out.println(getPermut("1001","0011"));

        System.out.println(getPermutationCount("111","111"));
       //System.out.println(getPermut("111","111"));

        System.out.println(getPermutationCount("1010","1010"));
        //System.out.println(getPermut("1010","1010"));


    }
}
