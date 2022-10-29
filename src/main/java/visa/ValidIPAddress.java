package visa;

//https://leetcode.com/problems/validate-ip-address/
public class ValidIPAddress {

    public static void main(String[] args) {
        String s1 = "172.16.254.1";
        System.out.println(validIPAddress(s1));
        String s2= "2001:0db8:85a3:0:0:8A2E:0370:7334";
        System.out.println(validIPAddress(s2));
    }

    public static String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(IP);
        }
        else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(IP);
        }
        else return "Neither";
    }

    static String validateIPv4 (String ip){
        //split based on .
        String[] nums = ip.split("\\.", -1);
        for (String s: nums){
            // validate  4 conditions
            // 1. less than 255
            if ( Integer.parseInt(s) > 255) return "Neither";
            // 2. only digits allowed
            for(char ch : s.toCharArray()){
                if (!Character.isDigit(ch)) return  "Neither";
            }
            // 3. no leading zero
            if (s.charAt(0)== '0' && s.length() != 1) return  "Neither";

            // 4. length of chunk is between 1 and 3
            if ( s.length() ==0 || s.length() > 3) return "Neither";
        }
        return "IPv4";
    }

    static String validateIPv6 (String ip){
        String[] nums = ip.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x: nums){
            // Validate hexadecimal in range (0, 2**16):
            // 1. at least one and not more than 4 hexdigits in one chunk
            if ( x .length()==0 || x.length() > 4) return "Neither";
            // 2. only hexdigits are allowed: 0-9, a-f, A-F
            for (char ch : x.toCharArray()){
                if (hexdigits.indexOf(ch)==-1) return "Neither";
            }
        }
        return "IPv6";

    }
}
