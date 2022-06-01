package Scal.Arrays.Hashing;

import java.util.HashMap;
import java.util.Map;
/*

 */
public class IsDict {
    private static int checkDictionary(String [] S, String B){

        Map<Character,Integer> indexMap = new HashMap<>();
        for (int i=0;i< B.toCharArray().length;i++){
            indexMap.put(B.charAt(i),i);
        }

        for(int i =1;i< S.length;i++){
            if (!compareAndValidate(indexMap, S[i-1], S[i]))
                return 0;
        }
        return 1;
    }

    private static boolean compareAndValidate(Map <Character,Integer> indexMap, String a, String b){
        int minLen = Math.min(a.length(), b.length());

        for (int i = 0; i < minLen; i++) {
            if (!(a.charAt(i) == b.charAt(i))) {
                return indexMap.get(a.charAt(i)) <= indexMap.get(b.charAt(i));
            }
        }
        return a.length() <= b.length();
    }

    public static void main(String[] args) {

        String [] data = { "hello", "scaler", "interviewbit"};
        String B = "adhbcfegskjlponmirqtxwuvzy";
        System.out.println(checkDictionary(data,B));

        String [] data1 = { "fine", "none", "no"};
        String B1 = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println(checkDictionary(data1,B1));

    }
}
