package Scal.Stacks1;

import java.util.Stack;

/*
Problem Description

You are given a string A.
An operation on the string is defined as follows:
Remove the first occurrence of same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".
Therefore the string after this operation will be "acd".

Keep performing this operation on the string until there are no more occurrences of same consecutive characters and return the final string.
 */
public class DoubleCharacter {
    private static String solve(String A){
        if (A==null) return null;
        // Solution - 1
//        Stack <Character> stack = new Stack<>();
//        for (char c : A.toCharArray()){
//            if (stack.isEmpty()){
//                stack.push(c);
//            }else {
//                if (stack.peek()== c){
//                    stack.pop();
//                }else{
//                    stack.push(c);
//                }
//            }
//        }

        //Solution -2 
        Stack <Character> stack = new Stack();
        for (char c : A.toCharArray()){
            if (!stack.isEmpty() && c==stack.peek()){
                stack.pop();
            } else stack.push(c);
        }
        //build response
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return  sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(solve("abccbc"));
    }
}
