package StriverSDE.Stacks;

import java.util.Stack;

/**  Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *     Every close bracket has a corresponding open bracket of the same type.
 */
public class BalancedParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        for (int i =0;i< s.length();i++){
            if (s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                st.push(s.charAt(i));
            }else {
                if (st.isEmpty())return  false;
                //check with top of stack and respective incoming character
                char c = st.pop();
                if( ( c == '(' && s.charAt(i)== ')') ||  ( c == '{' && s.charAt(i)== '}') || ( c == '[' && s.charAt(i)== ']') )
                    continue;
                //check for other next set of brackets
                else return  false;
            }
        }
        return  (st.isEmpty())? true: false;
    }

    public static void main(String[] args) {
        String s="()[{}()]";
        BalancedParentheses balancedParentheses = new BalancedParentheses();
        System.out.println(balancedParentheses.isValid(s));// expected true
    }
}
