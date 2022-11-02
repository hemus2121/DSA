package visa.String;

public class GCDOfStrings {

    public String gcdOfStrings(String str1, String str2){
        if ( !(str1+ str2) .equals(str2+str1) ) return "";
        else if (str1.equals(str2)) return  str1;
        // we need to remove smaller string from bigger string
        else if (str1.length() > str2.length())
            return gcdOfStrings(str1.substring(str2.length()), str2);
        else return  gcdOfStrings(str2.substring(str1.length()), str1);
    }
}
