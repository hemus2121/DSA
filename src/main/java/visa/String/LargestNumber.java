package visa.String;

//https://leetcode.com/problems/largest-number/
import java.util.Arrays;

public class LargestNumber {

    public static  String largestNumber(int[] nums) {

        //create string array by integer array
        String [] data = new String[nums.length];
        int index=0;
        for (int i : nums){
            data[index++] = String.valueOf(i);
        }

        // sort the array
        Arrays.sort(data, (s1,s2)-> (s2+s1).compareTo(s1+s2));

        //If 1st character is zero return 0
        if (data[0].equalsIgnoreCase("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : data){
            sb.append(s);
        }
        return  sb.toString();
    }

    public static void main(String[] args) {
        int [] nums ={ 3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }

}
