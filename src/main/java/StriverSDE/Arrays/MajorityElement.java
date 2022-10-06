package StriverSDE.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Majoriy Element -II
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 */
public class MajorityElement {
    private static  int[] getMajorityElement(int [] nums){
        // for N/3 majority we need to keep track by 2 buckets or variables
        int num1= -1, num2=-1, count1=0, count2=0, len = nums.length;
        for (int i=0;i< len;i++){
            if (nums[i]== num1) count1++;
            else if (nums[i] == num2) count2++;
            else if (count1 ==0){
                num1= nums[i];
                count1++;
            }else if (count2==0){
                num2= nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        //now check in input array
        List<Integer> ans = new ArrayList<>();
        count1=0;
        count2 =0;
        for (int i =0;i< len;i++){
            if ( nums[i]== num1) count1++;
            else if (nums[i]== num2) count2++;
        }
        if (count1 > len/3) ans.add(num1);
        if (count2 > len/3) ans.add(num2);
        //return ans.toArray(new int []);
        return ans.stream().mapToInt(aa ->aa).toArray();

    }
    public static void main(String[] args) {
        int [] data = { 3, 2, 3};
        System.out.println(Arrays.toString(getMajorityElement(data)));
    }
}
