package Scal.Arrays.Hashing;
/*  Pairs With Given Xor
Problem Description
Given an integer array A containing N distinct integers.
Find the number of unique pairs of integers in the array whose XOR is equal to B.
 */
import java.util.HashSet;
import java.util.Set;

public class PairsWithGivenXOR {
    private static int getPairCount(int [] A, int B){

        Set<Integer> dataSet = new HashSet<>();
        int pairCount =0;

        //Add array element into Set along with checking whether XOR with required number is already present
        for (int a: A){
            dataSet.add(a);
            if ( dataSet.contains(a ^B)){
                pairCount++;
            }
        }
        return pairCount;
    }
    public static void main(String[] args) {
        int [] data1 = {5, 4, 10, 15, 7, 6};
        System.out.println(getPairCount(data1,5));  //expected 1

        int [] data = { 3, 6, 8, 10, 15, 50};
        System.out.println(getPairCount(data,5)); //expected 2
    }
}
