package visa.String;

import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        int len = num.length();
        //corner case
        if (k == len) return "0";
        //Iterate for all characters in array
        Stack<Character> st = new Stack<>();
        for (char c : num.toCharArray()) {

            //whenever meet a digit which is less than the previous digit, discard the previous one
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            //add the incoming element
            st.add(c);
        }

        // corner case like "1111"
        while (k > 0) {
            st.pop();
            k--;
        }
        //Result builder stuff
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        //delete last character - 0 from MSB
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        //reverse builder and return string
        return sb.reverse().toString();

    }
}
