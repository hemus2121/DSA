package visa.String;

import java.util.Stack;
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

public class RemoveAllAdjDuplicateElements {

    //using Pair object
    static class Pair {
        char c ;
        int count;
        Pair(char c , int count){
            this.c = c;
            this.count = count;
        }
    }
    public static String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for (int i =0;i <s.length();i++){
            if (st.isEmpty() || s.charAt(i)!= st.peek().c){
                st.push (new Pair(s.charAt(i),1));
            }else {
                if (++st.peek().count==k){
                    st.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()){
            Pair p =st.pop();
            for (int i =0;i< p.count;i++){
                sb.append(p.c);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }
}
