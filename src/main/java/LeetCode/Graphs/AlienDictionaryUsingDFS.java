package LeetCode.Graphs;

import java.util.*;

/**  Alien Dictionary - -https://leetcode.com/problems/alien-dictionary/
 * There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
 * You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.
 * Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.
 * A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.
 */
public class AlienDictionaryUsingDFS {

    static Map<Character, List<Character>> charMap = new HashMap();
    static StringBuilder sb = new StringBuilder();
    static Map<Character, Boolean> visitedMap = new HashMap();

    static public String alienOrderUsingDFS(String[] words) {
        // lets build graph for characters
        if (!buildGraph(words)) return "";

        // iterate over adj Map and invoke dfs for each character
        for (Character c : charMap.keySet()){
            boolean result = dfs(c);
            if (!result) return "";
        }
        return sb.toString();
    }

    public static boolean dfs(Character c){

        //base case
        if (visitedMap.containsKey(c))
            return visitedMap.get(c);

        //initalizing to begin with -since we dont know
        visitedMap.put(c, false);

        //MAIN logic - iterate adjList of current character
        for (Character next: charMap.get(c)){
            boolean result = dfs(next);
            if (!result) return false;
        }
        // since we visitied adj list we shall mark it as true
        visitedMap.put(c, true);

        // append current character since we traversed it
        sb.append(c);
        return true;
    }

    private static boolean buildGraph(String[] words){

        //initial way of building map structure for unique characters
        for (String word:words){
            for (char c : word.toCharArray()){
                charMap.put (c, new ArrayList());
            }
        }


        for (int i=0;i< words.length-1;i++ ){
            String w1 = words[i];
            String w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());
            //we need to check for prefix match
            if (w1.length() > w2.length() && w1.startsWith(w2)){
                return false;
            }

            //building adj list - just iterate for min length
            for (int j =0;j< minLen;j++){
                if (w1.charAt(j) != w2.charAt(j)){
                    charMap.get(w2.charAt(j)).add(w1.charAt(j));
                    break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String [] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(alienOrderUsingDFS(words)); //expected : wertf

        String [] words1 = {"z","x","z"};
        System.out.println(alienOrderUsingDFS(words1)); //expected : ""
    }
}
