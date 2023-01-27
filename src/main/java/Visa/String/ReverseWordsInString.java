package Visa.String;

public class ReverseWordsInString {
    public  static String reverseWords(String s){
        if (s == null) return null;
        char [] a = s.toCharArray();
        int n = s.length();
        //Step1. reverse whole string
        reverse (a, 0, n-1);

        //Step2: reverse each word
        reverseWords(a, n);

        //Step3: clean up spaces
        return cleanSpaces(a, n);
    }

    static void reverse(char [] a, int i, int j){
        while (i <j) {
            char t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }

    static void reverseWords(char [] a, int n){
        int i =0, j=0;
        while (i <n){s
            while (i<j || i <n && a[i] == ' ') // skip starting spaces
                i++;
            while (j<i || j <n && a[j] != ' ') // skip non spaces
                j++;
            reverse (a,i, j-1); // reverse each words
        }
    }

    static String  cleanSpaces(char [] a, int n){
        int i =0, j=0;
        while (j <n){
            while (j<n && a[j] == ' ') //skip spaces
                j++;
            while (j<n && a[j] != ' ') //copy data
                a[i++] = a[j++];
            while (j<n && a[j]== ' ') //skip spaces
                j++;
            if (j<n) a[i++] = ' '; // keep only one space
        }
        return new String(a).substring(0,i);
    }

    public static  String reverseWordsUsingInbuilt(String s){
        String[] strs = s.split(" ");
        String res="";
        for (int i =0;i< strs.length;i++){
            if (strs[i].equals("")) continue;
            if (res.equals("")) res = strs[i];
            else res = strs[i]+" "+ res;
        }
        return res;
    }

    public static void main(String[] args) {
        String s ="the sky is blue";
        System.out.println(reverseWordsUsingInbuilt(s));
        System.out.println(reverseWords(s));
    }
}
