package Arrays;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    static Map<Character, Integer> romMap = new HashMap<>();
    static {
        romMap.put ('I', 1);
        romMap.put ('V', 5);
        romMap.put ('X', 10);
        romMap.put ('L', 50);
        romMap.put ('C', 100);
        romMap.put ('D', 500);
        romMap.put ('M', 1000);
    }

    // time - O(n) | space (1)
    public static int convertRomanToInt1(String s){
        int res =0;
        for (int i =0;i<s.length();i++){
            if (i>0 && romMap.get(s.charAt(i)) > romMap.get(s.charAt(i-1))){
                res =res- 2*romMap.get(s.charAt(i-1));
            }
            res = res +romMap.get(s.charAt(i));
    }
        return  res;
    }

    //time - O(n) | space (1)- uniform equation
    public static int convertRomanToInt2(String s){
        int res = 0;
        for (int i =0;i<s.length();i++){
            if ( i==0 || romMap.get(s.charAt(i))<= romMap.get(s.charAt(i-1))) res= res+ romMap.get(s.charAt(i));
            else res = res + (romMap.get(s.charAt(i))-2*romMap.get(s.charAt(i-1)));
        }
        return  res;
    }
    public static void main(String[] args) {
        System.out.println(convertRomanToInt1("IV"));
        System.out.println(convertRomanToInt2("IV"));

    }
}
