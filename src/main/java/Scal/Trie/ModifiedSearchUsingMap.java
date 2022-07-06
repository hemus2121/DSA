package Scal.Trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ModifiedSearchUsingMap {
    static class TrieNode{
        Map<Character, TrieNode> map = new HashMap<>();
        boolean isEnd;

        public void insert(String word){
            TrieNode curr = this;
            for (char c : word.toCharArray()){
                if (!curr.map.containsKey(c)){
                    curr.map.put(c, new TrieNode());
                }
                curr = curr.map.get(c);
            }
            curr.isEnd= true;
        }

        public boolean search (String word){
            TrieNode curr = this;
            for (char c : word.toCharArray()){
                if (! curr.map.containsKey(c)){
                    return false;
                }
                curr = curr.map.get(c);
            }
            return curr.isEnd;
        }
    }

    static public class Solution{
        public String solve(String []A, String [] B){
            TrieNode root = new TrieNode();


            for (String a: A){
                root.insert(a);
            }

            StringBuilder res = new StringBuilder();
            Set<String> hs = new HashSet<>();

            //iterate for all words present in Search
            for (int i =0;i< B.length;i++){

                String word = B[i];
                hs.add(word);
                int len = word.length();
                char [] w = word.toCharArray();
                boolean ret = false;

                for (int j =0;j< len;j++) {
                    char old = w[j]; //store old char

                    for (char k = 'a'; k <= 'z'; k++) { //iterate for all 26 characters
                        w[j] = k; // assign new character
                        String str = new String(w);
                        if (hs.contains(str)) continue;// if set already contains revised word continue
                        ret = root.search(str);// check if new word is present in trie
                        if (ret) break; //if already present break..
                    }
                    // revert back
                    if (!ret) {
                        w[j] = old;
                    } else break;
                }
                if (ret) res.append(1);
                else res.append(0);
            }
            return new String(res);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] A, B;
        {
            A = new String[] { "data", "circle", "cricket" };
            B = new String[] { "date", "circel", "crikket", "data", "circl" };
            String answer = solution.solve(A, B);
            System.out.println(answer);
        }
    }
}
