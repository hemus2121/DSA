package Scal.StringBasics;

import java.util.HashMap;
import java.util.Map;

public class WindowString {
    public static String getMinWindow(String A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        char[] b = B.toCharArray();

        //store the reference string in map
        for (char value : b) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        int resLen = Integer.MAX_VALUE;
        int size = map.size();
        int l = 0;
        int r = 0;

        StringBuilder str = new StringBuilder();
        while (r < A.length()) {
            if (map.containsKey(A.charAt(r))) {
                if (map.get(A.charAt(r)) == 1) { // if there is duplicates it will be handled A[AAAAAA] B[AA]
                    --size;
                }
                //reduce frequency of incoming character
                map.put(A.charAt(r), map.get(A.charAt(r)) - 1);
            }
            while (size == 0) {
                if (resLen > (r - l + 1)) {
                    str.delete(0, str.length());
                    str.append(A, l, l + (r - l + 1));
                    resLen = str.length();
                }
                if (map.containsKey(A.charAt(l))) {
                    //increase frequency of outgoing element if that is present in map
                    int val = map.get(A.charAt(l));
                    if (val == 0) {
                        ++size;
                    }
                    map.put(A.charAt(l), val + 1);
                }
                l++;
            }
            r++;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(getMinWindow("ADOBECODEBANC","ABC"));
    }
}
