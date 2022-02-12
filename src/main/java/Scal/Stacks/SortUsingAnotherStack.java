package Scal.Stacks;

import java.util.Arrays;
import java.util.Stack;

/*
Problem Description

Given a stack of integers A, sort it using another stack.
Return the array of integers after sorting the stack using another stack.
 */
public class SortUsingAnotherStack {

    private static  int [] sortDataUsingAnotherStack(int [] data){
        Stack <Integer> source = new Stack<>();
        Stack <Integer> dest = new Stack<>();
        //add current elements in to source stack
        for (int a: data){
            source.add(a);
        }
        //Now start pushing to destination stack
        while (!source.isEmpty()){
            int x = source.peek();
            source.pop();
            //checking condition where destination top element is > incoming element
            while (!dest.isEmpty() && dest.peek() > x){
                int temp = dest.peek();
                dest.pop();
                source.push(temp);
            }
            dest.push(x);
        }

        /* return response-- directly getting from destination using index - TRICK
        int [] res = new int[data.length];
        for (int i=0;i< A.length;i++){
            res[i]= d.get(i);
        } */

        //copy back elements
        while (!dest.isEmpty()){
            source.push(dest.pop());
        }

        //return to array
        int [] res = new int[data.length];
        int i =0;
        while (!source.isEmpty()){
            res[i++]=source.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        int [] data = {5,17,100,11};
        System.out.println(Arrays.toString(sortDataUsingAnotherStack(data)));
    }
}
