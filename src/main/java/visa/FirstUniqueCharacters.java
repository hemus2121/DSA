package visa;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacters {
    public static int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        }
        for (int i =0;i< s.length();i++){
            if (freqMap.get(s.charAt(i))==1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
