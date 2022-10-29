package visa;

//https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
//https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/discuss/1390249/JavaPython-3-Space-O(1)-time-O(n)-codes-w-brief-explanation.
//https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/discuss/1390319/How-to-reach-the-optimal-solution-or-Explained-with-Intuition-and-Diagram
public class StringBalanced {
    //without using extra Space  O(1)

    public  static  int minSwaps(String s) {
        int stack_size = 0;
        //If the current character is a '[', then we increment stack_size, else, we decrement it only if it is greater than 0 (meaning we have seen some valid [ brackets before, so this ] bracket is going to balance them out).
        // At the end, stack_size will contain the count of brackets which are not balanced, i.e [[[[[.....
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                stack_size++;
            } else {
                if (stack_size > 0) {
                    stack_size--;
                }
            }
        }
        return (stack_size + 1) / 2;
    }

    public  static  int minSwaps2Variables(String s) {
        int open=0, close=0;
        //If the current character is a '[', then we increment stack_size, else, we decrement it only if it is greater than 0 (meaning we have seen some valid [ brackets before, so this ] bracket is going to balance them out).
        // At the end, stack_size will contain the count of brackets which are not balanced, i.e [[[[[.....
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (open > 0 && ch == ']') {
                --open;
            }else if (ch == '[') {
                ++open;
            }else {
                ++close;
            }
        }
        return (open + 1) / 2;
    }

    public static void main(String[] args) {
        String data = "]]][[[";
        System.out.println(minSwaps(data));
        System.out.println(minSwaps2Variables(data));
    }
}
