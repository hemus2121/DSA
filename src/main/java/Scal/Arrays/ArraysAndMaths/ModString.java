package Scal.Arrays.ArraysAndMaths;
/* Mod String - Asked in Google
Problem Description
You are given a large number in the form of a string A where each character denotes a digit of the number.
You are also given a number B. You have to find out the value of A % B and return it.

 */
public class ModString {
    private static int computeModString(String A , int B){
        int n = A.length();
        long ans =0;
        long pow = 1;
        //iterate from Right to Left extracting each character and dealing with multiples of 10 and
        // applying mod for each character
        for (int i = n-1;i>=0;i--) {
            ans = ans + (A.charAt(i)-'0')* pow;
            ans = ans % B;
            pow = (pow * 10) % B;
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        System.out.println(computeModString("43535321",47));
        System.out.println(computeModString("23",25));
    }
}