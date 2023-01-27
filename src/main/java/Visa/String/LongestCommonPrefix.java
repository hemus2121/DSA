package Visa.String;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {

        // edge case
        if (strs.length ==1) return  strs[0];

        //get the minimim string lenght
        int min  =Integer.MAX_VALUE;
        for (String s : strs){
            min = Math.min(s.length(), min);
        }

        StringBuilder sb = new StringBuilder();
        // now we shall check for only 3 character length
        for (int i=0;i< min ;i++){

            //get the first character
            char c = strs[0].charAt(i);
            //next start comparision from next element in input array
            for (int j =1;j < strs.length;j++){
                if (c != strs[j].charAt(i)){
                    return sb.toString(); // this would return as soon as mismatch is found
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    static boolean isIsomorphic(String s, String t){
        Map map = new HashMap();
        for (int i =0;i< s.length();i++){
            if (map.put(s.charAt(i),i) != map.put(t.charAt(i)+"",i))
                return  false;
        }
        return true;
    }

    public static void main(String[] args) {
        String [] data = { "dog", "doggy"};
        System.out.println(longestCommonPrefix(data));
    }
}
