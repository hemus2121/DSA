package Scal.TwoPointers.Assi;

public class ContainerWithmostWater {
    public static int getMaxArea(int []A){

        if (A.length==1) return 0;
        int area, ans=Integer.MIN_VALUE;
        //lets have pointer at fartest distances apart
        int i =0,j=A.length-1;

        //until both points meet
        while(i !=j){
             area = (j-i)*Math.min(A[i],A[j]);
             ans = Math.max(ans, area);
             if (A[i]<A[j]){
                 i++;
             }else j--;
         }
         return ans;
    }
    public static void main(String[] args) {
        int [] data = {1, 5, 4, 3};
        System.out.println(getMaxArea(data));


    }
}
