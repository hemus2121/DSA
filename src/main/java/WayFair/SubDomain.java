package WayFair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** A website domain "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com" and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

 A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3" or "rep d1.d2" where rep is the number of visits to the domain and d1.d2.d3 is the domain itself.

 For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates that discuss.leetcode.com was visited 9001 times.
 Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each subdomain in the input. You may return the answer in any order.
 **/
public class SubDomain {
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map <String , Integer> domMap = new HashMap<>();
        List <String> resList = new ArrayList<>();

        // iterate over input array element
        for (int i =0;i< cpdomains.length;i++){
            String[] arrIntDom = cpdomains[i].split(" ");
            int visits = Integer.parseInt(arrIntDom[0]);

            //second element contains "discuss.leetcode.com" -- <key- name , value -- count >
            domMap.put(arrIntDom[1], domMap.getOrDefault(arrIntDom[1],0)+visits);

            //Split the domain in at least 2 //array contains "discuss", "leetcode.com"
            String [] arrSubDom2 =  arrIntDom[1].split("\\.",2);
            if(arrSubDom2.length == 2) {
                domMap.put(arrSubDom2[1], domMap.getOrDefault(arrSubDom2[1], 0) + visits);
            }

            //Split the domain in at least 3
            //array contains "discuss", "leetcode" ,"com"
            String [] arrSubDom3 = arrIntDom[1].split("\\.", 3);
            if (arrSubDom3.length==3) {
                domMap.put(arrSubDom3[2], domMap.getOrDefault(arrSubDom3[2], 0) + visits);
            }
        }

        //consturct the result - count and respective domain name
        for (String key : domMap.keySet()){
            resList.add((domMap.get(key))+ " "+ key);
        }
        return resList;

    }

    public static void main(String[] args) {
        String [] data = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(data));
    }
}
