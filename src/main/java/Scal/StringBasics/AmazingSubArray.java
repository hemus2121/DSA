package Scal.StringBasics;

/* Amazing Subarrays
You are given a string S, and you have to find all the amazing substrings of S.
An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 */
public class AmazingSubArray {
    private static int getCountOfSubArrays(String S){
        int n = S.length();
        int subArrayCount=0;

        //Kind of Contribution technique where each vowel character is present  (total size -index location of that character)
        for (int i=0;i<n;i++){
            if (isVowel(S.charAt(i))){
                subArrayCount += n-i;
            }
        }
        return  subArrayCount%10003;
    }

    //Method to check whether specific character is vowel or not
    static  boolean isVowel(char c){
        if ( c =='a' || c== 'e' || c=='i' || c =='o'|| c =='u'||
                c =='A' || c== 'E' || c=='i' || c =='o'|| c =='u'){
            return true;
        }return  false;
    }

    public static void main(String[] args) {
        System.out.println(getCountOfSubArrays("ABEC"));
    }
}
