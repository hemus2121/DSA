package Visa.String;

//https://leetcode.com/problems/string-compression/
public class StringCompression {
    public static int compress(char[] chars) {
        int index =0,len=0;
        while (len < chars.length){
            char curr = chars[len]; /// get the current character
            int count =0; // to have count of character
            //Check until end is reached and character is same as pervious
            while (len < chars.length && chars[len]== curr){
                len++;
                count++;
            }
            // copy incoming character
            chars[index++]= curr;

            if (count !=1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        char [] data = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compress(data));

    }
}
