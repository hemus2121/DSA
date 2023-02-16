package Scal.Arrays.ArraysDynamicArrays;

import java.util.Arrays;

//https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space/225291
public class ProductOfArrayExceptSelf{

    static public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Arrays.fill(res,1);
        int left =1,right =1;

        //lets compute left computation
        for (int i =0;i <n;i++){
            res[i] *= left;
            left *= nums[i];
        }

        for (int i = n-1;i >=0;i--){
            res[i] *= right;
            right*=  nums[i];
        }
        return res;
    }

    //Striver solution
    //https://takeuforward.org/arrays/product-of-array-except-itself/
    static public int[] productExceptSelf2ndWay(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int [] product = new int [n];

        prefix[0]=1;// since first element can have no prefix
        for (int i =1;i<n;i++) {
            prefix[i] = prefix[i-1]*nums[i-1];
        }

        int suffixproduct =1;
        for (int i =n-1;i>=0;i--){
            product[i] = suffixproduct * prefix[i];
            suffixproduct *= nums[i];
        }
        return product;
    }

    public static void main(String[] args) {
        int [] data = {1,2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(data)));

    }
}
