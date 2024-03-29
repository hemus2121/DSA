package Scal.DynamicProg;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Word break
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *  https://www.techiedelight.com/word-break-problem/
 * TC: O(n2) SC: O(sn)
 */
public class WordBreakProblem {
    // Function to determine if a string can be segmented into
    // space-separated sequence of one or more dictionary words
    public static boolean wordBreak(Set<String> dict, String word, int[] lookup)
    {
        // `n` stores length of the current substring
        int n = word.length();

        // return true if the end of the string is reached
        if (n == 0) {
            return true;
        }

        // if the subproblem is seen for the first time
        if (lookup[n] == -1)
        {
            // mark subproblem as seen (0 initially assuming string
            // can't be segmented)
            lookup[n] = 0;

            for (int i = 1; i <= n; i++)
            {
                // consider all prefixes of the current string
                String prefix = word.substring(0, i);

                // if the prefix is found in the dictionary, then recur for the suffix
                if (dict.contains(prefix) && wordBreak(dict, word.substring(i), lookup))
                {
                    // return true if the string can be segmented
                    lookup[n] = 1;
                    return true;
                }
            }
        }

        // return solution to the current subproblem
        return lookup[n] == 1;
    }

    public static void main(String[] args) {
        // Set of strings to represent a dictionary
        // we can also use a Trie or a List to store a dictionary
        Set<String> dict = Stream.of("this", "th", "is", "famous",
                        "Word", "break", "b", "r", "e", "a", "k",
                        "br", "bre", "brea", "ak", "problem")
                .collect(Collectors.toSet());

        // input string
        String word = "Wordbreakproblem";

        // lookup array to store solutions to subproblems
        // lookup[i] stores if substring word[n-i…n) can be segmented or not
        int[] lookup = new int[word.length() + 1];
        Arrays.fill(lookup, -1);

        if (wordBreak(dict, word, lookup)) {
            System.out.println("The string can be segmented");
        }
        else {
            System.out.println("The string can't be segmented");
        }
    }
}
