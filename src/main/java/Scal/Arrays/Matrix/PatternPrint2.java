package Scal.Arrays.Matrix;

/*
Problem Description
Print a Pattern According to The Given Value of A.
Example: For A = 3 pattern looks like:

    1
  2 1
3 2 1
 */
public class PatternPrint2 {

    static int [] [] generatePattern(int A){
        int [][] res = new int [A][A];
        int colindex=A-1;
        for (int row=0;row<A;row++){
            for (int col= colindex;col>=colindex-row;col--){
                res[row][col]= colindex-col+1;
            }
        }
        return res;

        /*int[][] ans = new int[A][A];
        for(int i=0;i<A;i++)
        {
            for(int j=0;j<A-i-1;j++)
                ans[i][j]=0;
            int col = A-i-1;
            for(int j = i+1;j>=1;j--)
                ans[i][col++]=j;
        }
        return ans; */
    }
    public static void main(String[] args) {
        System.out.println(generatePattern(3));
    }
}
