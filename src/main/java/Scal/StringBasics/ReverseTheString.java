package Scal.StringBasics;

public class ReverseTheString {

    /** Method without using inbuilt split functionality */
    private static String reverseString(String A){
        int len = A.trim().length();
        StringBuilder reversedString = new StringBuilder(A.trim());

        for (int i =0;i< len/2;i++){
            reverse( reversedString,i, len-1-i);
        }

        int startIndex=0;
        for (int i =0;i< len;i++){
            // this will check if ending character is space or end of line
            if (reversedString.charAt(i)==' ' || (i==len-1)){

                // get the end Index
                int endIndex = (i < (len-1))? i-1: i;

                while (startIndex <endIndex){
                    reverse(reversedString, startIndex, endIndex);
                    startIndex++;
                    endIndex--;
                }
                startIndex =i+1;
            }
        }
        return reversedString.toString();
    }

    static  void reverse(StringBuilder sb , int start, int end){
        char temp = sb.charAt(start);
        sb.setCharAt(start,sb.charAt(end));
        sb.setCharAt(end, temp);
    }

    /** Method using inbuilt split functionality */
    public static String reverseSol2(String A){
        String[] strWords = A.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int s = strWords.length - 1; s >= 0; s--) {
            if (ans.toString().isEmpty()){
                ans.append(strWords[s]);
            }else
                ans.append(" ").append(strWords[s]);
        }
        return  ans.toString();
    }
    public static void main(String[] args) {
        String s = " love hate data structures";
        System.out.println(reverseString(s));
        System.out.println(reverseSol2(s));
    }
}
