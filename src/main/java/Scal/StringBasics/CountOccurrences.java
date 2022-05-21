package Scal.StringBasics;

/* Count Occurrences
Problem Description
Find the number of occurrences of bob in string A consisting of lowercase English alphabets.
*/

public class CountOccurrences {
    private static int getCount (String s ){
        int count=0;
        for (int i =0;i<=s.length()-3;i++) {
            if (s.substring(i, i + 3).equalsIgnoreCase("bob")) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(getCount("bobob")); //expected 2
    }
}
