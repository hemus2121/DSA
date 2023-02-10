package StriverSDE.Stacks;

import java.util.Stack;

/**
 * Implement Min Stack : O(2N) and O(N) Space Complexity
 *
 * Problem Statement: Implement Min Stack | O(2N) and O(N) Space Complexity. Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */

class Pair {
    int x, y; // stores actual value and minimum value till now
    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class MinStack {
    Stack<Pair> st ;
     MinStack (){
         st = new Stack();
     }

     public void push(int x){
         int min;
         if (st.isEmpty()){
            min = x ;
         } else {
             min = Math.min(st.peek().y, x);
         }
         st.add(new Pair(x, min)); //storing minimum till now
     }

     public void pop(){
         st.pop();
     }
     int top(){
         return st.peek().x;
     }
     int getMin(){
         return st.peek().y;
     }
}
