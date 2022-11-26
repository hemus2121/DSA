package Visa.String;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeat {
    public  static int lengthOfLongestSubstring(String s) {

        //Using Sliding Window concept
        int n = s.length();
        int l =0, r=0;
        int ans = Integer.MIN_VALUE;
        //to store unique elements
        Set<Character> st = new HashSet<>();
        //edge case
        if (n==1) return 1;

        //start sliding- r keeps incrementing
        while (r<n){
            //new character incoming is already present then shrink window
            if (st.contains(s.charAt(r))){
                st.remove(s.charAt(l));
                l++;
            }else {
                //add new incoming character to set
                st.add(s.charAt(r));
                r++;
                // compute answer till no w
                ans = Math.max(ans, st.size());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s ="pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
