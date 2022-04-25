package Scal.Stacks;

import java.util.*;
/*
Given string A denoting an infix expression. Convert the infix expression into postfix expression.
String A consists of ^, /, *, +, -, (, ) and lowercase english alphabets where lowercase english alphabets are operands and ^, /, *, +, - are operators.
Find and return the postfix expression of A.
 */

public class InfixToPostfix {

    private static String postfix(String A){

        Map <Character,Integer> preMap = new HashMap<>();
        // store the precedence first in descending order
        preMap.put('^',3);
        preMap.put('*',2);
        preMap.put('/',2);
        preMap.put('+',1);
        preMap.put('-',1);

        //result postfix Expression
        StringBuilder expression = new StringBuilder();
        Stack<Character> st = new Stack();

        for (char c : A.toCharArray()){
            //check if char is btwn a and z
            if (c >='a' && c <='z') expression.append(c);
            else if (c =='(') st.push(c); // if opening brack push to stack
            else if (c == ')'){
                //pop everything until opening bracket
                while  (st.peek() !='('){
                    expression.append(st.pop());
                }
                //pop the closing bracket also
                st.pop();
            } else{ //if operator
                // run while if strack top precedence <= curr element prec , pop everything
                while (!st.isEmpty() && st.peek() !='(' && preMap.get(c)<= preMap.get(st.pop())){
                    expression.append(st.pop());
                }
                //push curr operator to stack
                st.push(c);
                st.peek();
            }
        }
        while (!st.isEmpty()){
            expression.append(st.pop());
        }
        return expression.toString();
    }

    public static void main(String[] args) {
        System.out.println(postfix("x^y/(a*z)+b"));
        System.out.println(postfix("a*(r+o*h)"));
    }
}