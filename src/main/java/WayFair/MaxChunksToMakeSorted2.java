package WayFair;

public class MaxChunksToMakeSorted2 {
    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int [] maxLeft = new int [n];
        int [] minRight = new int [n];

        maxLeft[0]= arr[0];
        for (int i =1;i<n;i++){
           maxLeft[i] = Math.max(maxLeft[i-1], arr[i]);
        }

        minRight [n-1]= arr[n-1];
        for (int i =n-2;i>=0;i--){
            minRight[i] = Math.min(minRight[i+1], arr[i]);
        }

        int res =1;
        //condition check
        for (int i=0;i<n-1;i++){
            if (maxLeft [i] <= minRight[i+1])
                res++;
        }
        return res;
    }
    public static void main(String[] args) {
        int [] data = {2,1,3,4,4};
        System.out.println(maxChunksToSorted(data));
    }
}
