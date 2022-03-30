package Scal.DynamicProg.TwoDArray;
/*
Partition a set into two subsets such that sum of each subset is same

Ref: https://iq.opengenus.org/split-set-into-two-subset-with-same-sum/
 */
public class SubsetEqualSum {
    static boolean checkPartition (int [] A, int n){
        int sum =0;

        // get the sum of elements in array to check for even or odd
        for (int a : A){
            sum +=a;
        }
        if (sum %2!=0) return  false;

        //dynamic array
        boolean [][] part = new boolean [ n+1][sum/2+1];
        //init top row as false
        for (int i=0;i<= sum/2;i++){
            part[0][i] = false;
        }
        //init 1st column as true
        for (int i =0;i<=n;i++){
            part[i][0]=true;
        }

        //compute using 2 loops
        for (int i =1;i<=n;i++){
            for (int j=1;j<=sum/2;j++){
                if (j >= A[i-1]) {
                    part[i][j] = part[i][j] || part[i - 1][j - A[i - 1]];
                }else {
                    part[i][j]=  part[i-1][j];
                }
            }
        }
        return part[n][sum/2];
    }
    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 6, 7, 11};
        int n = arr.length;
        if (checkPartition(arr, n)) System.out.println("can be partitioned");
        else System.out.println("can not be partitioned");
    }
}
