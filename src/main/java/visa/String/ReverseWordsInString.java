package visa.String;

public class ReverseWordsInString {
    public String reverseWords(String s){
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
        while (i <n){
            while (i<j &&i <n && a[i] == ' ')i++;// skip spaces
            while (j<i &&j <n && a[j] != ' ')j++; // skip non spaces
            reverse (a,i, j-1);
        }
    }

    String cleanSpaces(char [] a, int n){
        int i =0, j=0;
        while (j <n){
            while (j<n && a[j] == ' ')j++;
            while (j<n && a[j] != ' ')a[i++] = a[j++];
            while (j<n && a[j]== ' ')j++;
            if (j<n) a[i++] = ' ';
        }
        return new String(a).substring(0,i);
    }

    public static  String reverseWordsUsingInbuilt(String s){
        String[] strs = s.split(" ");
        String res="";
        StringBuilder sb = new StringBuilder();
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
    }
}
