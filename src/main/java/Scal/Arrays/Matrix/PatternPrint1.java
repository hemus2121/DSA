package Scal.Arrays.Matrix;

/*
Problem Description

Print a Pattern According to The Given Value of A.
Example: For A = 3 pattern looks like:

1 0 0
1 2 0
1 2 3
 */
public class PatternPrint1 {
    private  static  int [][] generate(int A){

        int [][] result = new int [A][A];

//        for (int i=1;i<=A;i++){
//            for (int j =1; j<=A;j++){
//                if (j<=i) {
//                    result [i-1][j-1] = j;
//                }
//            }
//        }

        for(int i = 0; i < A; ++i){
            for(int j = 0; j <= i; ++j)
                result [i][j] = j + 1;
        }
       return result;

    }
    public static void main(String[] args) {
        System.out.println(generate(3));
    }
}
