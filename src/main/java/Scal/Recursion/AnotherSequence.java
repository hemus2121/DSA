package Scal.Recursion;

/** Another Sequence
 * Problem Description
 * Given a sequence f(A) = f(A-1) + f(A-2) + f(A-3) + A . Calculate the Ath term of the sequence.
 * Given f(0)=1; f(1)=1; f(2)=2;
 */
public class AnotherSequence {
    private static  int anotherSequence(int A){
        return getSequence(A);
    }
    static int getSequence(int A){
        //Base Case
        if (A==0 || A==1) return 1;
        if (A==2) return 2;
        return getSequence(A-1) + getSequence(A-2)+ getSequence(A-3) +A;
    }
    public static void main(String[] args) {
        System.out.println(anotherSequence(3)); //expected 7
    }
}
