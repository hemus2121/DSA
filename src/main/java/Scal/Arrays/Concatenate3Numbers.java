package Scal.Arrays;

import java.util.PriorityQueue;

/* Concatenate Three Numbers

Problem Description
Given three 2-digit integers, A, B, and C, find out the minimum number obtained by concatenating them in any order.
Return the minimum result obtained.
 */
public class Concatenate3Numbers {

    private static int concatenate3Numbers(int a, int b, int c){

        //lets use priority Que- since we want minimum once all the time
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        pq.add(a);
        pq.add(b);
        pq.add(c);

        String ans ="";
        while (!pq.isEmpty()){
            ans = ans + pq.poll();
        }
        return Integer.parseInt( ans);
    }
    public static void main(String[] args) {
        System.out.println(concatenate3Numbers(44, 45, 43)); //expected is 434445
    }
}
