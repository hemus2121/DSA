package Scal.Recursion;
/*
Guess the output for the following program:
 */
public class Output7 {
    private static int fun(int x, int n){
        //Base case
        if (n==0) return 1;
        else if (n%2 ==0)
            return fun(x*x, n/2);
        else return x * fun(x*x, (n-1)/2);
    }
    public static void main(String[] args) {
        System.out.println(fun(2,10)); //expected 1024
    }
}
