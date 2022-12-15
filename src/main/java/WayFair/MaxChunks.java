package WayFair;

public class MaxChunks {

    /** In general idea is maximum till now should be less than minimum from right then only we can make chunk .
     (minimum have place in right array itself because it is greater than maximum of left).
     If minimum from right is less than maximum from left then in sorted array the position of minimum is in left part so therefore we cannot create chunk in that case..

     Steps to follow:

     Always check for edge case if array length is 0 what to do.
     Make 2 arrays maximum from left and minimum from left.
     now check maximum till now <= minimum from right then chunk is possible(increase chunk count)
     **/
    public static int maxChunksToSorted(int[] arr) {
        if (arr.length==0) return 0;
        //create new 2 arrays
        int n= arr.length;
        int [] maxFromStart = new int [n];
        int [] minFromEnd = new int [n];

        // get the maximmum elements from left
        maxFromStart[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>maxFromStart[i-1]){
                maxFromStart[i]=arr[i];
            }else{
                maxFromStart[i]=maxFromStart[i-1];
            }
        }

        //get the minimum element from right
        minFromEnd[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<minFromEnd[i+1]){
                minFromEnd[i]=arr[i];
            }else{
                minFromEnd[i]=minFromEnd[i+1];
            }
        }

        //check the chunk count
        int chunk=1;
        for(int i=0;i<arr.length-1;i++){
            if(maxFromStart[i]<=minFromEnd[i+1]){
                chunk++;
            }
        }
        return chunk;
    }

    public static void main(String[] args) {
        int [] data = {2,1,3,4,4};
        System.out.println(maxChunksToSorted(data));
    }
}
