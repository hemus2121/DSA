package Scal.Stacks1;

import java.util.Stack;

/*
Problem Description

Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

Input Format
The first and the only argument of input contains the string A having the paranthesis sequence.

Output Format
Return 0, if the paranthesis sequence is not balanced.
Return 1, if the paranthesis sequence is balanced.
 */
public class BalancedParanthesis {
    private static int checkParanthesis(String A){
        if(A==null) return 0;
        Stack <Character> stack = new Stack();
        //iterate over input string char by character
        for (char c : A.toCharArray()){
            if (c =='{' || c=='(' || c=='['){
                stack.push(c);
            }else {
                //critical block
                if (stack.isEmpty()) return 0;
                if (c=='}' && stack.peek() !='{')return 0;
                if (c==']' && stack.peek() !='[')return 0;
                if (c==')' && stack.peek() !='(')return 0;
                stack.pop();
            }
        }
        return stack.isEmpty()?1:0;
    }
    public static void main(String[] args) {
        System.out.println(checkParanthesis("())"));
        System.out.println(checkParanthesis("{([])}"));
    }
}
