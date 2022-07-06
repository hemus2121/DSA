package Scal.Trie;

public class ModifiedSearch {

    static class TrieNode{

        private TrieNode[] links ;
        private Character data;
        private boolean isEnd;
        private final static int CAPACITY = 26;

        TrieNode(char data) {
            this.data = data;
            links = new TrieNode[CAPACITY];
        }

        public void addWord(String word){
            TrieNode root = this;
            for (int i =0;i< word.length();i++){
                char c = word.charAt(i);
                if (root.links[c-'a']== null){
                    root.links[c-'a'] = new TrieNode(c);
                }
                root = root.links[c-'a'];
            }
            root.isEnd = true;
        }

        //Recursive DFS way to search for specific node
        public boolean searchWord(String word, boolean isChanged, int index){
            TrieNode root = this ;
            //Base case -- if we reach to end and only 1 character is replaced
            if (index == word.length()){
                return  isChanged && root.isEnd;
            }

            //Main Logic
            if (isChanged == false){
                // if character is not replaced, try all possibilities of replacing current
                // character
                for (int i =0;i< 26;i++){
                    if (root.links[i]!= null){
                        // consider replacing only when next character is not present in trie
                        if (root.links[i].data != word.charAt(index) &&
                            root.links[i].searchWord(word, true,index+1))
                            return true;
                    }
                }
            }

            // move next if we find the matching character in Trie
            if ((root.links[word.charAt(index) -'a']) !=null){
                if (root.links[word.charAt(index)-'a'].searchWord(word, isChanged, index+1))
                    return true;
            }
            return false;
        }
    }

    public String solve(String []A, String[] B){
        TrieNode trie = new TrieNode('#');
        //buildTree
        for (String s: A ){
            trie.addWord(s);
        }

        StringBuilder sb = new StringBuilder();
        for (int i =0;i< B.length;i++){
            boolean isFound = trie.searchWord(B[i],false, 0);
            if (isFound) sb.append("1");
            else sb.append("0");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ModifiedSearch ms = new ModifiedSearch();
        String[] A, B;
        {
            A = new String[] { "data", "circle", "cricket" };
            B = new String[] { "date", "circel", "crikket", "data", "circl" };
            // B = new String[] { "data" };
            String answer = ms.solve(A, B);
            System.out.println(answer);
        }
    }
}
