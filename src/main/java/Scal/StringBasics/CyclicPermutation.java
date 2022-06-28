package Scal.StringBasics;

import java.util.Arrays;

/* Cyclic Permutations
Given two binary strings A and B, count how many cyclic permutations of B when taken XOR with A give 0.

NOTE: If there is a string, S0, S1, ... Sn-1 , then it's cyclic permutation is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1
where k can be any integer from 0 to N-1.
 */
public class CyclicPermutation {
    private static int getPermutationCount(String A,String B){
        //A is reference String and B is input string
        B = B+B;
        String str = A+'$'+B.substring(0, B.length()-1);

        //Z array definition
        int Z[] = new int [str.length()];
      
        // ZAlgorigthm
        zAlgoImplement(str,Z);


        int reqLen= A.length();
        int countOfFreqLen=0;
        for (int z : Z){
            if (z==reqLen){
                countOfFreqLen++;
            }
        }
        return countOfFreqLen;
    }

    private static void zAlgoImplement(String s, int [] Z){
        int l =0,r=0;
        for (int i=1;i<s.length();i++){
            // case of outside segment (region) - apply BF
            if (i>r){
                l=i;r=i;
                while(r <s.length() && (s.charAt(r)==s.charAt(r-l)) ){
                    r++;
                }
                Z[i]=r-l;
                r--;
            }else {
                // copy section where both are equal
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
        System.out.println(getPermutationCount("1001","0011"));  //expected 1
        System.out.println(getPermutationCount("111","111"));  //expected 3
        System.out.println(getPermutationCount("1010","1010")); //expected 2
    }
}
