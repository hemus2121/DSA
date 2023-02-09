package Visa.String;

/** Greatest Common Divisor of Strings
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 */
public class GCDOfStrings {

    public static  int gcd (int x, int y){
        if(y ==0)  return x;
        else return gcd( y, x%y);
    }

    public static  String gcdOfStrings(String str1, String str2){
        if ( !(str1+ str2) .equals(str2+str1) ) return "";

        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC","ABC"));
    }
}
