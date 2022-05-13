package Scal.Arrays.ArraysDynamicArrays;
/* Primal Power
Problem Description
"Primal Power" of an array is defined as the count of prime numbers present in it.
Given an array of integers A of length N, you have to calculate its Primal Power.
 */

public class PrimalPower {
    private static int  computeMultiplication(int [] A){
        int primeCount=0;
        for (int a : A){
            if (a>0){
                if (isPrime(a)) primeCount++;
            }
        }
        return primeCount;
    }

    // check the prime factors  i^2<=N
    private static boolean isPrime(int n ){
        if (n<=1) return false;
        for (int i =2;i*i <= n;i++){
            if (n%i==0) {
                return false;
            }
        }
        return  true;
    }
    public static void main(String[] args) {
        int [] data = {-6, 10, 12};
        System.out.println(computeMultiplication(data)); //expected 0
        int [] data1= {-11, 7, 8, 9, 10, 11};
        System.out.println(computeMultiplication(data1)); //expected 2
    }
}
