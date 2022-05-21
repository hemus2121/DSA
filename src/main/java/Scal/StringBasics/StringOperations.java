package Scal.StringBasics;

import java.util.HashSet;
import java.util.Set;

public class StringOperations {
    private static String modifyString(String A){
        String revisedString = A +A;
        Set<Character> vowSet = new HashSet<>();
        vowSet.add('a');
        vowSet.add('e');
        vowSet.add('i');
        vowSet.add('o');
        vowSet.add('u');

        StringBuilder sb = new StringBuilder();
        for (char c : revisedString.toCharArray()){
            if ( Character.isLowerCase(c)){
                if (vowSet.contains(c)){
                    sb.append('#');
                }
                else sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input ="AbcaZeoBAbcaZeoB";
        System.out.println(modifyString(input));
    }
}
