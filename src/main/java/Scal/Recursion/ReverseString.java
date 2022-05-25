package Scal.Recursion;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        int n = data.length();
        reverseString(data.toCharArray(), n);
    }
    static void reverseString(char [] data, int n){
        // Base case
        if (n ==0) return;
        //Main Logic
        System.out.print(data[n-1]);
        reverseString(data, n-1);
    }
}
