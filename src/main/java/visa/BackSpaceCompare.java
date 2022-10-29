package visa;

import java.util.Stack;
//https://leetcode.com/problems/backspace-string-compare/

public class BackSpaceCompare {
    public static  boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public static String build (String s){
        Stack<Character> st = new Stack();
        for(char c : s.toCharArray()){
            if ( c != '#'){
                st.push(c);
            }else if (!st.isEmpty()){
                st.pop();
            }
        }
        return String.valueOf(st);
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c","ad#c"));
    }
}
