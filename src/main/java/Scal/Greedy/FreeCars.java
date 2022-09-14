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

        Pair(int time ,int profit){
            this.time = time;
            this.profit = profit;
        }
    }
        private static int computeMaxProfit(int [] A, int [] B){

        //priority Que to hold data based on deadline
            PriorityQueue<Integer> pq = new PriorityQueue();
            List<Pair> deadLineList = new ArrayList<>();
            for (int i =0;i< A.length;i++){
                deadLineList.add(new Pair(A[i], B[i]));
            }

            Collections.sort(deadLineList, (Pair p1, Pair p2) -> {
                return p1.time -p2.time;
            });

            int time =0;
            for (Pair p : deadLineList){
                if (time <= p.time-1){
                    time++;
                    pq.add(p.profit);
                }else {
                    if (pq.peek() < p.profit){
                        pq.poll(); //extracting minimum
                        pq.add(p.profit); //adding higher profits
                    }
                }
            }

            //Computing total profit
            int totalProfit =0;
            int mod = (int) Math.pow(10,7)+9;
            while (pq.size() >0){
                totalProfit += pq.poll();
                totalProfit %=mod;
            }
            return  totalProfit;
        }
    public static void main(String[] args) {
        int [] A = {1, 3, 2, 3, 3};
        int [] B =  {5,6,1,3,9};
        System.out.println(computeMaxProfit(A, B)); //expected 20
    }
}
