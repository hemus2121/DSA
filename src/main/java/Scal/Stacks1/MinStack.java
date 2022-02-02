package Scal.Stacks1;

import java.util.Stack;

/*
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

NOTE:
    All the operations have to be constant time operations.
    getMin() should return -1 if the stack is empty.
    pop() should return nothing if the stack is empty.
    top() should return -1 if the stack is empty.
 */
public class MinStack {
    Stack<Integer> origStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x){
        origStack.push(x);
        if (!minStack.isEmpty() && x < minStack.peek()){
            minStack.push(minStack.peek());
        }else minStack.push(x);
    }

    public void pop(){
        if (origStack.isEmpty()) return ;
        origStack.pop();
        minStack.pop();
    }

    public int top(){
        return origStack.isEmpty()? -1: origStack.peek();
    }

    public int getMin(){
        return origStack.isEmpty()? -1: minStack.peek();
    }

    public static void main(String[] args) {

    }
}
