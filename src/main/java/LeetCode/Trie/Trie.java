package LeetCode.Trie;

/** 208- Implement Trie (Prefix Tree) --https://leetcode.com/problems/implement-trie-prefix-tree/
 *A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 * TC:(n* wordlenght*26) -- Insert    SC:n* wordlength*26
 */
class TrieNode{

    boolean isEnd;
    TrieNode [] children;
    int count;

    TrieNode(){
        children = new TrieNode[26];
    }

    //put
    void put(char c){
        children[c -'a'] = new TrieNode();
    }

    TrieNode get(char c){
        return children[c-'a'];
    }

    void setEnd(){
        isEnd = true;
    }

    boolean isEnd(){
        return isEnd;
    }

    void setCount(){
        count++;
    }

    int getCount(){
        return count;
    }

    boolean contains(char c){
        return children[c-'a']!=null;
    }
}

public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()){
            if (!curr.contains(c)){
                curr.put(c);
            }
            curr = curr.get(c);
        }
        curr.setCount();
        curr.setEnd();
    }
    // one search method for searching in
    public TrieNode searchInTrie(String word){
        TrieNode curr = root;
        for (char c : word.toCharArray()){
            if (curr.get(c)!=null){
                curr = curr.get(c);
            }else {
                return null;
            }
        }
        return curr;
    }

    public boolean search(String word) {
        TrieNode trie = searchInTrie(word);
        return trie != null && trie.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode trie = searchInTrie(prefix);
        return trie != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.print("null ");
        trie.insert("apple");
        System.out.print("null ");
        System.out.print(trie.search("apple")+ " ");   // return True
        System.out.print(trie.search("app")+ " ");     // return False
        System.out.print(trie.startsWith("app")+ " "); // return True
        trie.insert("app");
        System.out.print("null"+ " ");
        System.out.print(trie.search("app")+ " ");     // return True
    }

}
