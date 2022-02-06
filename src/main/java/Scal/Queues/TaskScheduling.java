package Scal.Queues;

import java.util.LinkedList;
import java.util.Queue;
/*
Problem Description
A CPU has N tasks to be performed. It is to be noted that the tasks have to be performed in a specific order to avoid deadlock. In every clock cycle the CPU can either perform a task or move it to the back of the queue. You are given the current state of the scheduler queue in an array A and the required order of the tasks in an array B.

Determine the minimum number of clock cycles to complete all the tasks.
 */
public class TaskScheduling {
    private static int totalTasks(int [] A, int [] B){
        //referenc q
        Queue <Integer> refQue = new LinkedList<>();
        for (int a: A){
            refQue.add(a);
        }
        int clcokCycleCount = 0;
        //iterate over B to find jobs
        for (int i =0;i<B.length;i++){
            while (B[i]!= refQue.peek()){
                int temp = refQue.peek();
                refQue.remove();
                clcokCycleCount++;
                refQue.add(temp);
            }
            clcokCycleCount++;
            refQue.remove();
        }
        return clcokCycleCount
    }
    public static void main(String[] args) {
        int [] A = {2, 3, 1, 5, 4};
        int [] B = {1, 3, 5, 4, 2};
        System.out.println(totalTasks(A, B));

        int [] AA={ 6, 7, 1, 2, 4, 5, 8, 3 };
        int [] BB= { 3, 7, 2, 5, 1, 8, 4, 6 };
        System.out.println(totalTasks(AA, BB));
    }
}
