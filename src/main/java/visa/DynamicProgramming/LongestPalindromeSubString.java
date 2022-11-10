package visa.DynamicProgramming;

// Time: O(N^2)
// Space: O(N)
public class LongestPalindromeSubString {

    private static String getLongestPalindrome(String s) {

        // EXPAND from center approach
        String maxPalindrome = "";
        for (int i = 0; i < s.length(); i++) {

            //Odd length palindrome
            String palindrome = expand(s, i, i);
            //store the highest maximum String
            if (maxPalindrome.length() < palindrome.length()) {
                maxPalindrome = palindrome;
            }

            //handle even case
            palindrome = expand(s, i, i + 1);
            //compare with previous maximum string
            if (maxPalindrome.length() < palindrome.length()) {
                maxPalindrome = palindrome;
            }
        }
        return maxPalindrome;
    }

    static String expand(String s, int p1, int p2) {
        while (p1 >= 0 && p2 < s.length() && (s.charAt(p1) == s.charAt(p2))) {
            p1--;
            p2++;
        }
        return s.substring(p1 + 1, p2);
    }

    public static void main(String[] args) {
        String s = "xbdyzzydbdyzydx";
        System.out.println(getLongestPalindrome(s));
    }
}
