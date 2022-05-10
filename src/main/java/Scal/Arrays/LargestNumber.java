package Scal.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    private static String largestNumber(final int []A){

        //Convert Integer array to String array
        String [] data = new String [A.length];
        int index=0;
        for (int a :A){
            data[index++] = String.valueOf(a);
        }

        //if input data starts with 0 return 0
        if (data[0].equalsIgnoreCase("0"))return "0";

        //Sort using comparator
        Arrays.sort(data,(s1, s2) -> (s2+s1).compareTo (s1+s2) );

        StringBuilder sb = new StringBuilder();
        for (String s : data){
            sb.append(s);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int [] data = { 3, 30, 34, 5, 9};
        System.out.println(largestNumber(data)); //expecte - 9534330
    }
}
