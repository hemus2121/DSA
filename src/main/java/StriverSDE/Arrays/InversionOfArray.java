package StriverSDE.Arrays;

/** Inversion count in an Array
 * Problem Description
 * Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
 */
public class InversionOfArray {

    private static int merge(int [] A, int [] temp, int left, int mid, int right){
        int inv_count =0;
        int i =left, j =mid, k =left;
        while (i <= mid-1 & j<= right){
            if (A[i]<= A[j]){
                temp[k++] = A[i++];
            }else {
                temp[k++]= A[j++];
                inv_count = inv_count + (mid-i);
            }
        }
        while (i <= mid-1){
            temp[k++]= A[i++];
        }

        while (j<= right){
            temp[k++] = A[j++];
        }
        //copy back to original array
        //for (i=left;i<= right;i--){
        int index =0;
        for (int t: temp){
            A[index++] = t;
        }
        return inv_count;
    }
    private static int merge_Sort(int [] A, int[] temp, int left, int right){
        int mid, inv_count =0;
        if (right >left){
            mid = (left+right)/2;
            inv_count +=merge_Sort(A, temp, left, mid);
            inv_count += merge_Sort(A, temp,mid+1, right);
            inv_count += merge(A, temp,left,mid+1, right);
        }
        return inv_count;
    }
    public static void main(String[] args) {
        int arr[]={5,3,2,1,4};
        int n=5;
        int [] temp = new int [n];
        System.out.println("inversion count : "+ merge_Sort(arr,temp,0,n-1)); //expected 7
    }
}
