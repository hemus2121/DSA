package StriverSDE.Stacks;

import java.util.LinkedList;
import java.util.Queue;

/** Implement Stack using single Queue
 * Problem Statement: Implement a Stack using a single Queue.
 * TC: SC: O(N)
 */
class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        // take out all element from Q and add back to end of Q
        for (int i =0;i< q.size()-1;i++){
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return  q.peek();
    }

    public boolean empty() {
        return  q.isEmpty();
    }
    public int size(){
        return q.size();
    }

}
public class StackUsingQueue {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(1);
        System.out.println("Top of the stack: " + s.top());
        System.out.println("Size of the stack before removing element: " + s.size());
        System.out.println("The deleted element is: " + s.pop());
        System.out.println("Top of the stack after removing element: " + s.top());
        System.out.println("Size of the stack after removing element: " + s.size());
    }
}
