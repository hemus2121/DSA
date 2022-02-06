package Scal.Queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Problem Description

Given an integer A. Find and Return first positive A integers in ascending order containing only digits 1, 2 and 3.
NOTE: All the A integers will fit in 32 bit integer.
 */
//https://www.javatpoint.com/java-priorityqueue
public class NintegersContaining123 {

    private static int [] generateNIntegers(int A){
       Queue<Integer> queue = new LinkedList();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //result holder from Q
        ArrayList<Integer> res = new ArrayList();

            while (res.size() < A) {
                //peek and element have same funtionality
                int temp = queue.peek();
                res.add(temp);
                queue.remove(temp);
                //compute next 3 number
                queue.add(temp*10+1);
                queue.add(temp*10+2);
                queue.add(temp*10+3);
            }

        return res.stream().mapToInt(val -> val).toArray();
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateNIntegers(7)));
    }

}
