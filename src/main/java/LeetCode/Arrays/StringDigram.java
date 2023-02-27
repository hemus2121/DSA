package LeetCode.Arrays;
/*
We are given a string S consisting of N lowercase letters. A sequence of two adjacent letters inside a string is called a digram. The distance between two digrams is the distance between the first letter of the first digram and the first letter of the second digram. For example, in string S = "akcmz" the distance between digrams "kc" and "mz" is 2.
We want to find the distance between the furthest identical digrams inside string S.
Write a function:
    class Solution { public int solution(String S); }
that, given a string S consisting of N letters, returns the distance between the two identical digrams in the string that lie furthest away from each other. If there are no two identical digrams inside S, your function should return -1.
Examples:
1. Given S = "aakmaakmakda" your function should return 7. The furthest identical digrams are "ak"s, starting in positions 2 and 9 (enumerating from 1): "aakmaakmakda".
2. Given S = "aaa" your function should return 1. The furthest identical digrams are "aa"s starting at positions 1 and 2.
3. Given S = "codility" your function should return -1. There are no two identical digrams in S.
Write an efficient algorithm for the following assumptions:
        N is an integer within the range [2..300,000];
        string S is made only of lowercase letters (a−z).
*/
import java.util.HashMap;
import java.util.Map;

public class StringDigram {
    public static int maxDistDigrams(String S){
        // TC : O(n) SC : O(1)
         if(S.length() <=2) return  -1;
         int ans = -1;
         Map<Integer, Integer> sumMap = new HashMap<>();
         int first = S.charAt(0);
         for (int i =1;i< S.length();i++){
             int second = S.charAt(i);
             int intSum = first + second;
             if (first> second){
                 intSum *=-1;
             }
             if (sumMap.containsKey(intSum)){
                 int firstIndex  = sumMap.get(intSum);
                 ans = Math.max(ans, i-1-firstIndex);
             }else {
                 sumMap.put(intSum, i-1);
             }
             first = second;
         }
         return  ans;
    }

    public static void main(String[] args) {
        System.out.println(maxDistDigrams("aakmaakmakda"));
        System.out.println(maxDistDigrams("aaa"));
        System.out.println(maxDistDigrams("codility"));
    }
}
