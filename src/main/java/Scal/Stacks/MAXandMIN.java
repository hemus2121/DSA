package Scal.Stacks;

import java.util.Stack;

/*
Problem Description

Given an array of integers A .

value of a array = max(array) - min(array).

Calculate and return the sum of values of all possible subarrays of A % 109+7.
 */
public class MAXandMIN {
    public static int getDiffMAxMin(int []A){
        if (A.length==1) return 0;

        long ans = 0;
        long maxCont=0, minCont=0;
        int mod = (int)Math.pow(10,9)+7;

        //we need 4 arrays to find max and min of all elements
        int [] nearSmallestLeft = nearSmallestLeft(A);
        int [] nearSmallestRight = nearSmallestRight(A);
        int [] nearLargestLeft = nearGreatestLeft(A);
        int [] nearLargestRight = nearGreatestRight(A);

        System.out.println("nearSmallestLeft--> "+nearSmallestLeft);
        System.out.println("nearSmallestRight-->"+nearSmallestRight);
        System.out.println("nearLargestLeft-->"+nearLargestLeft);
        System.out.println("nearLargestRight-->"+nearLargestRight);

        for (int i =0;i<A.length;i++){
            int j = nearLargestLeft[i];
            int k = nearLargestRight[i];
            maxCont= ((long)(i-j)*(k-i));

            int jj = nearSmallestLeft[i];
            int kk = nearSmallestRight[i];
            minCont = ((long)(i-jj)*(kk-i));
            ans = ((maxCont-minCont)*A[i]%mod)%mod + ans%mod;
        }
        //revised to handle negative value coming for 1 TC
        return (int) (ans+mod)%mod;
    }
    public static int [] nearSmallestLeft(int []A){
        int [] res = new int [A.length];
        Stack<Integer> st = new Stack();
        for (int i =0;i< A.length;i++){
            while (!st.isEmpty() && A[st.peek()]>=A[i]){
                st.pop();
            }
            if (st.isEmpty()) res[i]=-1;
            else res[i]= st.peek();
            st.push(i);
        }
        return res;
    }

    ////just iterating from length of array side i.e start from (Array.length-1)
    ///if not found Assign A.length to result
    public static int [] nearSmallestRight(int [] A){
        int [] res = new int [A.length];
        Stack<Integer> st = new Stack();
        for (int i =A.length-1;i>-1;i--){
            while (!st.isEmpty() && A[st.peek()]>=A[i]){
                st.pop();
            }
            if (st.isEmpty()) res[i]=A.length;
            else res[i]= st.peek();
            st.push(i);
        }
        return res;
    }


    // GREATEST ELEMENT SECTION
    // condition in while reverses from smallest i.e. peek <= A[i]
    public static int [] nearGreatestLeft(int []A){
        int [] res = new int [A.length];
        Stack<Integer> st = new Stack();
        for (int i =0;i< A.length;i++){
            while (!st.isEmpty() && A[st.peek()]<=A[i]){
                st.pop();
            }
            if (st.isEmpty()) res[i]=-1;
            else res[i]= st.peek();
            st.push(i);
        }
        return res;
    }

    // if not found Assign A.length to result
    public static int [] nearGreatestRight(int [] A){
        int [] res = new int [A.length];
        Stack<Integer> st = new Stack<>();
        for (int i =A.length-1;i>-1;i--){
            while (!st.isEmpty() && A[st.peek()]<=A[i]){
                st.pop();
            }
            if (st.isEmpty()) res[i]=A.length;
            else res[i]= st.peek();

            st.push(i);
        }
        return  res;
    }

    public static void main(String[] args) {
        int [] data = { 4, 7, 3, 8};
        System.out.println(getDiffMAxMin(data));
    }
}
