package WayFair;

//https://leetcode.com/problems/add-strings


public class AddStrings {
    public static  String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry=0;
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        while (p1 >=0 || p2 >=0){
            int x1 = p1 >=0 ? num1.charAt(p1)- '0': 0;
            int x2 = p2 >=0 ? num2.charAt(p2) -'0': 0;
            int value =(x1 + x2 + carry) %10;
            carry = (x1 + x2 + carry) / 10;
            sb.append(value);
            p1--;
            p2--;
        }

        if (carry !=0)
            sb.append(carry);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("456","77"));
    }
}
