package Scal.DynamicProg;

public class FiboNumber {
    private static int data[];

    public static int solve(int n){
        data = new int [n+1];
        return compute(n);
    }
    private static int compute(int n){
        if (n<=1) return n;
        if (data[n] != 0) return data[n];
        data[n]= compute(n-1) + compute(n-2);
        return data[n];
    }

    public static void main(String[] args) {
        System.out.println(solve((6)));
    }
}
