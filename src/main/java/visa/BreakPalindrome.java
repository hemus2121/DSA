package visa;

public class BreakPalindrome {

    public String breakPalindrome(String s){
        int n = s.length();

        if (n==1) return "";

        char [] p  = s.toCharArray();
        for (int i =0;i< n/2;i++){
            //  here we know that as long as palindrome[i] is "a", we skip it
            if (p[i] != 'a'){
                // otherwise, we replace the first character that is not "a"
                p[i]='a';
                return new String (p);
            }
        }
        p[n-1]='b';
        return new String(p);
    }
}