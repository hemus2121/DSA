package Scal.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/** Free Cars
 * Problem Description
 * Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money.
 *
 * B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.
 *
 * Your task is to find the maximum profit one can earn by buying cars considering that you can only buy one car at a time.
 */
public class FreeCars {

    static class Pair{
        int time;
        int profit;
        Pair(int time, int profit){
            this.time = time;
            this.profit = profit;
        }
    }
        private static int computeMaxProfit(int [] A, int [] B){

            int mod = 1000000007;
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            ArrayList<Pair> list = new ArrayList<>();
            int maxProfit = 0;
            for(int i = 0; i < A.length; i++){
                list.add(new Pair(A[i], B[i]));
            }
            Collections.sort(list, (Pair a, Pair b) -> (a.time - b.time));
            int t = 0;
            for(Pair car : list){
                int time = car.time;
                int profit = car.profit;
                if(t < time){
                    minHeap.add(profit);
                }
                else if(--t < time && profit > minHeap.peek()){
                    minHeap.remove();
                    minHeap.add(profit);
                }
                t++;
            }
            while(!minHeap.isEmpty()){
                maxProfit = ( maxProfit + minHeap.remove()) % mod;
            }
            return maxProfit;
        }
    public static void main(String[] args) {
        int [] A = {1, 3, 2, 3, 3};
        int [] B =  {5,6,1,3,9};
        System.out.println(computeMaxProfit(A, B)); //expected 20
    }
}
