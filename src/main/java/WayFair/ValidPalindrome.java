package WayFair;

public class ValidPalindrome {
    private static boolean isValid(String inputData){

        StringBuilder sb = new StringBuilder();
        for (char c : inputData.toCharArray()){
            if (Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c)); // conversion to lower case is critical
            }
        }

        //we shall check using 2 pointers
        int i=0,j = sb.length()-1;
        while (i < j){
            if (sb.charAt(i++) != sb.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String data ="A man, a plan, a canal: Panama";
        System.out.println(isValid(data));
    }
}
