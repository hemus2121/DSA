package LeetCode.Gen.Stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 */
public class ValidParanthesis {


    //Sol1 - With Extra Space of Map
    private static boolean checkParan1(String s){
        Map<Character,Character > map = new HashMap();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> st = new Stack<>();

        for (int i =0;i< s.length();i++){
            Character c = s.charAt(i);
            if (c =='(' || c =='[' || c=='{'){
                st.push(c);
            }else if ( st.isEmpty() || st.peek() != map.get(c)) {
                return false;
            }else {
                st.pop(); // remove matching brackets
            }
        }

        return st.isEmpty();
    }

    //Sol1 - WithOUT Extra Space of Map- BEST
    private static boolean checkParan2(String s){
         Stack<Character> st = new Stack();

        for (int i = 0; i < s.length(); ++i) {
            Character c = s.charAt(i);
            if (c == '(' || c =='{' || c =='[') st.push(c);
            else {
                if (st.isEmpty()) return false;
                if ( c ==')' && st.peek() != '(') return  false;
                else if ( c ==']' && st.peek() != '[') return  false;
                else if ( c =='}' && st.peek() != '{') return  false;
                st.pop();
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(checkParan1("()"));
        System.out.println(checkParan1("(]"));

        System.out.println(checkParan2("()"));
        System.out.println(checkParan2("(]"));
    }
}
