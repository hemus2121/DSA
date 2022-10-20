package StriverSDE.Stacks;

import java.util.Stack;

/**
 * Implement Queue using Stack
 * Problem Statement: Given a Stack having some elements stored in it. Can you implement a
 * Queue using the given Stack?
 */
public class QueueUsingStack {
    Stack<Integer> ist;
    Stack<Integer> ost;

    public QueueUsingStack() {
        ist = new Stack<>();
        ost = new Stack<>();
    }

    public void push(int x) {
        ist.push(x);
    }

    public int pop() {
        //push all element from input stack to output stack from where we shall peek and pop
        if (ost.isEmpty()) {
            while (!ist.empty()) {
                ost.push(ist.pop());
            }
        }
        return ost.pop();
    }

    public int peek() {
        if (ost.empty()) {
            while (!ist.isEmpty()) {
                ost.push(ist.pop());
            }
        }
        return ost.peek();
    }

    public boolean empty() {
        return ost.isEmpty() && ist.isEmpty();
    }
}
