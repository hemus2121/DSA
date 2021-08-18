package Arrays;

public class ContainerWithMostWater {

    /*
    Given  n  non-negative integers  a1 ,  a2 , ...,  an  , where each represents a point at coordinate ( i ,  ai ).
     n  vertical lines are drawn such that the two endpoints of line  i  is at ( i ,  ai ) and ( i , 0).
    Find two lines, which together with x-axis forms a container, such that the container contains the most water.
    Note: You may not slant the container and  n is at least 2.
     */

    //The key idea here is that , for any container, the water it could contain is determined by the shorter height.
    // Try candidate from the far left and far right. Always move the shorter pointer to the center.

    // TODO- time O(n)  || space (1)
    public static  int maxArea(int [] height){
       int left = 0;
       int right = height.length-1;
       int res =0;
       while (left < right){
           //get which is minimum either of left or right
           int h = Math.min(height[left], height[right]);
           // get maximum area height * breadth
           res = Math.max(res, h *(right-left));

           // check between left and right pointers which ever is less  move it accordingly
           if (height[left] < height[right]) left++;
           else right--;
       }
       return  res;
    }

    // APPROACH 2-->The following method is a small optimization of the above method.
    // For the same height, we can directly move left and right, and no longer calculate the capacity.
    public static int maxArea1(int [] height){
        int left =0, right = height.length-1;
        int res =0;
        while (left <right){
            int h = Math.min(height[left], height[right]);
            res = Math.max(res, h*(right- left));
            while (left < right && h == height[left]) left++;
            while (left < right && h == height[right]) right--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int [] {1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea1(new int [] {1,8,6,2,5,4,8,3,7}));
    }
}
