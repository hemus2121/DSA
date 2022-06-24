package LeetCode.Graphs;
/** Word Ladder
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */

import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> patternMap =  new HashMap();

        // check whethter wordList contains endWrod if not return
        if (!wordList.contains(endWord)) return 0;

        // lets us append begin word to wordList to consider as one group
        wordList.add(beginWord);


        //we need length of beginWord
        int l = endWord.length();

        //Lets iterate wordList - build adjList kind
        wordList.forEach( word -> {
            //iterate for length of words
            for (int i =0;i< l;i++){
                String pattern = new StringBuilder(). append(word.substring(0,i)).append("*").append(word.substring(i+1)).toString();
                List<String> tempWordList = patternMap.getOrDefault(pattern, new ArrayList());
                tempWordList.add(word);
                patternMap.put(pattern, tempWordList); // Ex: *ot --> hot
            }
        });


        //Actual BFS starts
        int level =1;
        Set<String> visited = new HashSet();
        Queue <String> que = new LinkedList();

        que.offer(beginWord);
        visited.add(beginWord);

        while (!que.isEmpty()){
            int qsize = que.size();

            for(int i=0;i<qsize;i++){
                String temp = que.poll();
                //check if that is the end word
                if(temp.equalsIgnoreCase(endWord)) return level;

                for (int ii=0;ii<l;ii++){
                    String pattern1 = new StringBuilder().append(temp.substring(0,ii)).append("*").append(temp.substring(ii+1)).toString();

                    //get adjList elements for matching pattern
                    for (String neighbour : patternMap.get(pattern1)){
                        if (!visited.contains(neighbour)){
                            visited.add(neighbour);
                            que.add(neighbour);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord ="cog";
        List<String> wordList= new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
       // wordList.add("ram");
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
}
