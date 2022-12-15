package WayFair;

//https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/

//https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/discuss/1285942/JAVA-solution-with-visual-explanation
public class FullRounds {
    public static int numberOfRounds(String loginTime, String logoutTime) {
        //convert everything into minutes
        int startH = Integer.parseInt(loginTime.substring(0,2));
        int startM = Integer.parseInt(loginTime.substring(3));

        int endH = Integer.parseInt(logoutTime.substring(0,2));
        int endM = Integer.parseInt(logoutTime.substring(3));

        //convert everything into minutes
        int start = startH*60 + startM;
        int end = endH* 60 + endM;

        // when start > end (play overnight), we can simply shift the end time by 24 hours
        if (start > end)
            end +=  24*60;

        int finalValue = (int) (Math.floor(end / 15f) - Math.ceil(start / 15f));
        return finalValue < 0 ? 0:  finalValue;
    }

    public static void main(String[] args) {
        System.out.println(numberOfRounds("21:30","03:00"));
    }
}
