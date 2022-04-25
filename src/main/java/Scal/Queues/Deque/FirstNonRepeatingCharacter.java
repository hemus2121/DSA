package Scal.Queues.Deque;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    private static String getNonRepeting(String A){
        Deque <Character> deque = new LinkedList();
        StringBuilder sb = new StringBuilder();

        //maintain map of incoming elements
        Map<Character, Integer> freqMap = new HashMap();

        for (char c : A.toCharArray()){
            //increase frequency count
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
            // add incoming element to Q from last
            deque.addLast(c);


            // check if first element freq is >1 keep popping from first
            while (!deque.isEmpty() && freqMap.get(deque.peekFirst()) > 1) {
                deque.removeFirst();
            }

            if (!deque.isEmpty()) sb.append(deque.getFirst());
            else sb.append("#");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        //expect output is - jjjjjjjjjjjjjjjjjjjjjyyyyyyyyyyyyyyyyyyyyyyyyyyyqqqqq
      System.out.println(getNonRepeting("jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl"));

        System.out.println(getNonRepeting("abadbc"));
        System.out.println(getNonRepeting("abcabc"));
    }
}
