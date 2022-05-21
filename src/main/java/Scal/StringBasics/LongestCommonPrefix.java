package Scal.StringBasics;

/*
 Longest Common Prefix
 Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
 */

/**
 * Vertical Scanning or Column Scanning. Here character at the same index is
 * compared. If the character at the same index in all input strings is same,
 * add it to the prefix. Else, return the found prefix.
 *
 * Using StringBuilder to keep track of the result
 * TC: O(N * minLen + N)  SC: O(minLen)
 * N = Number of strings in strs. minLen = Length of smallest string in Input array.
 */

public class LongestCommonPrefix {
    private static String  getLongestCommonPrefixSol1(String [] data){
        //if only once string is present
        if (data.length==1) return data[0];

        //find length of shortest string so that we can compare only upto that length
        int minLen = Integer.MAX_VALUE;
        for (String s : data){
            minLen = Math.min(minLen, s.length());
        }

        //compare only that much length of characters
        StringBuilder sb = new StringBuilder();
        for (int i =0;i<minLen;i++){
            char c = data[0].charAt(i);
            //start comparison with next set of String elements  in input array
            for (int j =1;j< data.length;j++){
                if (c != data[j].charAt(i)){
                    return  sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /** Time complexity : O(S) , where S is the sum of all characters in all strings. In the worst case there will be
     equal strings with length and the algorithm performs S=m⋅n character comparisons. */
    private static String  getLongestCommonPrefixSol2(String [] data){
        //if only once string is present
        if (data.length==0 ||data ==null ) return "";

        //Start with  1st sting in array as reference
        for (int i =0;i<data[0].length();i++){
            char c = data[0].charAt(i);

            //start comparison with next array element of String input array
            for (int j =1;j< data.length;j++){
                // if there is mismatch of character or length of 1st string == next string length return sub string
                if ( c != data[j].charAt(i) || i == data[j].length()){
                    return  data[0].substring(0,i);
                }
            }
        }
        return data[0];
    }
    public static void main(String[] args) {
        String [] data = {"flower","flow","flight"};
        System.out.println(getLongestCommonPrefixSol1(data));
        System.out.println(getLongestCommonPrefixSol2(data));
    }
}
