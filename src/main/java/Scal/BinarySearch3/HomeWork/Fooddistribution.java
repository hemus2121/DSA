package Scal.BinarySearch3.HomeWork;
/*
The government wants to set up B distribution offices across N cities for the distribution of food
packets. The population of the ith city is A[i]. Each city must have at least 1 office,
and people can go to an office of their own city.
 We want to maximize the minimum number of people who can get food in any single office.
 */
public class Fooddistribution {

    private static int getFoodDistribution(int[]A, int B){
        // we need to find minimum value to be A[i] because that has to be given
        int minimumNoPeople = Integer.MAX_VALUE;
        int totalNoOfPeople = 0;
       for (int a: A){
           if (a <minimumNoPeople) minimumNoPeople =a;
           totalNoOfPeople +=a;
       }
       //edge case - we can't distribute if total sum is less than B office
        if (totalNoOfPeople< B) return 0;

        //normal bs
        int l =1, r= minimumNoPeople, ans=0;
        while (l<=r){
            int mid = (l +r) /2;
            if (check(A, mid, B)){
                ans = mid;
                l= mid+1;
            }else r = mid-1;
        }
        return  ans;
    }

    // check whether each element devided by K (mid) sums up to B required offices
    private static boolean check (int []A, int k, int B){
        int req=0;
        for (int a : A){
            req += a/k;
        }
        return req >=B ;
    }

    public static void main(String[] args) {
        int [] A={5 ,10,15};
       // System.out.println(getFoodDistribution(A, 7));

        int [] AA= {10000, 20000, 30000};
       // System.out.println(getFoodDistribution(AA,6));

        int []AAA={9, 8, 9};
        System.out.println(getFoodDistribution(AAA,4));
    }
}
