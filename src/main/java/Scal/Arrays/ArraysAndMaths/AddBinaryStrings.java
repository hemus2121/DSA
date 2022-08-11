package Scal.Arrays.ArraysAndMaths;

/** Add Binary Strings
 * Problem Description
 * Given two binary strings, return their sum (also a binary string).
 * Example:
 * a = "100"
 * b = "11"
 * Return a + b = "111".
 */
public class AddBinaryStrings {

    private static String addBinary (String A, String B) {
        String res="";
        int m = A.length()-1, n = B.length()-1, carry=0;

        while (m >=0 || n >=0){
            int p = m >=0 ? A.charAt(m)-'0':0;
            int q = n >=0 ? B.charAt(n)-'0':0;
            int sum = p+q+carry;
            res = ""+ (sum%2) + res;
            carry = sum /2;
        }
        return carry ==1 ?  1+res: res;
    }
    public static void main(String[] args) {
        String a= "100";
        String b ="11";
        System.out.println(addBinary(a, b));//expected 111
    }
}
