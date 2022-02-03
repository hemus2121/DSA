package Scal.Stacks1;
import java.util.*;

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
