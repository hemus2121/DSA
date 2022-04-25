package Scal.BackTracking;

/*
Print all N digits which can be formed from digits {1, 2}
 */
public class PrintAllDigitswith12 {

    public static void printDigits(){
        final int N = 4; // this defines how many elements is needed
        int [] ans = new int [N];
        printAllDigits(0, N,ans );
    }

    public  static void printAllDigits(int i, int n, int []ans ){
        if (i==n){
            for(int j=0;j<n;j++){
                System.out.print(ans[j]);
            }
            System.out.println("\t");
            return;
        }
        ans[i]=1;
        printAllDigits(i+1, n, ans);
        ans[i]=2;
        printAllDigits(i+1, n, ans);
    }
    public static void main(String[] args) {
        printDigits();
    }
}
