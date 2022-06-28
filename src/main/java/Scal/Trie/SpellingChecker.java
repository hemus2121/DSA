package Scal.Trie;

import java.util.Arrays;

/** Spelling Checker
 * Problem Description
 * Given an array of words A (dictionary) and another array B (which contain some words).
 * You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.
 * Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
 * Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.
 * NOTE: Try to do this in O(n) time complexity.
 */
public class SpellingChecker {

    //template class
    static class TrieNode{
        private boolean isEnd;
        private int count;
        private TrieNode [] links ;
        private final static int CAPACITY = 26;

        TrieNode() { links = new TrieNode[CAPACITY];}

        boolean contains(char c) { return links[c-'a'] != null; }

        TrieNode get(char c) { return links[c-'a']; }
        void put (char c) { links[c -'a'] = new TrieNode(); }

        boolean isEnd() { return this.isEnd; }
        void setEnd() { isEnd = true;}

        void setCount() { count++; }
        int getCount() { return count; }
    }

    //Class with helper methods
    static class Trie{
        TrieNode root ;

        Trie() { root = new TrieNode();}

        void insert(String word){
            TrieNode curr = root;
            for (char c : word.toCharArray()){
                if (!curr.contains(c)){
                    curr.put(c);
                }
                curr = curr.get(c);
            }
            curr.setEnd();
            curr.setCount();
        }

        //Traverse Trie till the end node and return last trie
        TrieNode searchKey (String word){
            TrieNode curr = root;
            for (char c : word.toCharArray()){
                if (curr.contains(c)){
                    curr = curr.get(c);
                }else {
                    return null;
                }
            }
            return curr;
        }

        //search word
        public boolean search (String word){
            TrieNode node =searchKey(word);
             return (node != null && node.isEnd());
        }

        //start with
        public boolean startsWith(String word){
            TrieNode node = searchKey( word);
            return  node != null? true: false;
        }

        //countwordsEqual method
        public int countWordsEqualTo(String word){
            TrieNode node = searchKey( word);
            return node != null && node.isEnd()? node.getCount():0;
        }

        //count words start with
        public int countWordsStartWith(String word){
            TrieNode node = searchKey( word);
            return node != null? node.getCount():0;
        }
    }

    public static int[] solve(String[] A, String[] B) {
        Trie trie = new Trie();
        for (String a: A){
            trie.insert(a);
        }

        int [] res = new int[B.length];
        int index=0;
        for (String b: B){
            if (trie.search(b)){
                res[index++]=1;
            }else {
                res[index++]=0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String [] A= {"hat", "cat", "rat" };
        String [] B = {"cat", "ball"};
        System.out.println(Arrays.toString(solve(A, B))); //expected [1, 0]

        String [] AA = {"tape", "bcci" };
        String [] BB= { "table", "cci"};
        System.out.println(Arrays.toString(solve(AA,BB))); //expected [0,0]

        }
}
