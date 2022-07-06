package Scal.Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/** Bth Smallest Prime Fraction - Leet code question - https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/1852749/JAVAHEAP-Solution-with-explanation
 * Problem Description
 *
 * Given a sorted array of integers A which contains 1 and some number of primes.
 * Then, for every p < q in the list, we consider the fraction p / q.
 * What is the B-th smallest fraction considered?
 *
 * Return your answer as an array of integers, where answer[0] = p and answer[1] = q.
 */

class Fractions{
    int i, j;
    double num1, num2, val;
    Fractions(int i, int j, double num1, double num2){
        this.i =i;
        this.j =j;
        this.num1 = num1;
        this.num2 = num2;
        this.val = num1/num2;
    }
}
public class BthSmallestPrimeFraction {


    private static int [] computeBthSmallestPrimeFraction(int []A, int B){

        PriorityQueue <Fractions> pq = new PriorityQueue<>((a,b)-> Double.compare(a.val, b.val));

        //fix the last element and add fraction from 1st to last
        int lastIndex = A.length-1;
        for (int i=0;i< A.length-1;i++){
            pq.offer(new Fractions(i, lastIndex, (double)A[i], (double) A[lastIndex]));
        }

        //poll for Bth smallest fractions
        while ( B !=1){
            Fractions f = pq.poll();
            int numIndex = f.i;
            int denIndex = f.j;
            if (denIndex >0) {
                denIndex--;
            }
            //Add back element to pq again
            pq.add(new Fractions(numIndex, denIndex, A[numIndex], A[denIndex]));
            B--;
        }

        Fractions fr = pq.poll();
        return new int[]{ (int) fr.num1, (int)fr.num2};
    }

    public static void main(String[] args) {
        int [] A = { 1, 2, 3, 5};
        int B =3;
        System.out.println(Arrays.toString(computeBthSmallestPrimeFraction(A,B))); //expected [ 2, 5]
    }
}
