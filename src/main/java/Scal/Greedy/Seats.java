package Scal.Greedy;

import java.util.ArrayList;
import java.util.List;

/** Seats
 * Problem Description
 *
 * There is a row of seats represented by string A. Assume that it contains N seats adjacent to each other.
 * There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.
 * An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')
 * Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.
 * In one jump a person can move to the adjacent seat (if available).
 *
 * NOTE: 1. Return your answer modulo 107 + 3.
 */
public class Seats {

    private static  int getSeatsCount(String A){
        long mod = (long) Math.pow(10,7) +3;
        //to store position for x characters in input String s
        List<Integer> posList = new ArrayList<>();
        for ( int i =0;i< A.length();i++){
            if (A.charAt(i)=='x'){
                posList.add(i);
            }
        }

        //Since we need to compute min distance we should have middle point of posList
        int mid = posList.size()/2;
        int left = mid-1, right = mid+1, k =1; // k denotes middle posn count where its fixed
        long res=0;
        //compute left
        while (left >=0){
            res = (res+ posList.get(mid)-k-posList.get(left))%mod;
            left--;
            k++;
        }

        //compute right
        k=1;
        while (right < posList.size()){
            res = (res +posList.get(right) - k - posList.get(mid))%mod;
            right++;
            k++;
        }
        return (int) (res%mod);
    }
    public static void main(String[] args) {
        String A= "....x..xx...x..";
        System.out.println(getSeatsCount(A)); //expected 5
    }
}
