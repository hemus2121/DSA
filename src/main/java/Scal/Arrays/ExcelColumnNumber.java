package Scal.Arrays;
/*
Excel Column Number
Problem Description

Given a column title as appears in an Excel sheet, return its corresponding column number.
Problem Constraints
1 <= length of the column title <= 5

 */
public class ExcelColumnNumber {
    private static int titleToNumber(String A){
        int pow =1, ans=0;
        int n = A.length();
        
        //Just iteration from Right to left  confining to range from Z-A
        // + 1 is required to get actual difference
        for (int i = n-1;i>=0;i-- ){
            ans = ans +( A.charAt(i)-'A'+1 )* pow;
            pow = pow * 26;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(titleToNumber("ABCD")); // ans 19010
    }
}
