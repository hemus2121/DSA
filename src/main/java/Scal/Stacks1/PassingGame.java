package Scal.Stacks1;

import java.util.Stack;

public class PassingGame {

    public static int solve(int A, int B, int[] C) {
        Stack<Integer> stack = new Stack();
        //since is B is element which is initalized we shall add to stack first
        stack.add(B);
        for (int c : C){
            if (c==0)stack.pop();
            else stack.push(c);
        }
        return stack.peek();
    }
    public static void main(String[] args) {
        System.out.println(solve(1,1, new int []{2}));
    }
}
