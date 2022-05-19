package Scal.StringBasics;
/* Simple Reverse
Problem Description
Given a string A, you are asked to reverse the string and return the reversed string.
 */
public class SimpleReverse {
    private static String getReverse(String s ){

        StringBuilder sb = new StringBuilder();
        for (int lastIndex = s.length()-1; lastIndex >=0; lastIndex--){
            sb.append(s.charAt(lastIndex));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(getReverse("scaler"));
    }
}
