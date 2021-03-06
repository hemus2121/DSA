package Scal.Stacks;
import java.util.*;

/*
Problem Description

An arithmetic expression is given by a character array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each character may be an integer or an operator.
 */
public class EvaluateExpression {
    private static int evaluateExpression(String[] A){
        Stack<Integer> stack= new Stack();
        for (String s: A){
            if (s.equalsIgnoreCase("+")){
                stack.push(stack.pop() + stack.pop());
                continue;
            }
            if (s.equalsIgnoreCase("-")){
                int temp = stack.pop();
                stack.push(stack.pop()-temp);
                continue;
            }
            if (s.equalsIgnoreCase("*")){
                stack.push(stack.pop()* stack.pop());
                continue;
            }
            if (s.equalsIgnoreCase("/")){
                int temp = stack.pop();
                stack.push(stack.pop() / temp);
                continue;
            }
            stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String [] data ={ "2", "1", "+", "3", "*"};
        System.out.println(evaluateExpression(data));
    }
}
