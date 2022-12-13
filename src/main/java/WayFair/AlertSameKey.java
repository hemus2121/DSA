package WayFair;

import java.util.*;
// Question -- https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
//https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/discuss/878329/Java-O(nlogn)-HashMap%2BTreeSet-without-sorting.
//T/S: O(n lg n)/O(n), where n = size(keyName)
public class AlertSameKey {
    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String , TreeSet<Integer>> freMap = new HashMap();
        for (int i =0;i< keyName.length;i++) {
            if (!freMap.containsKey(keyName[i])) {
                freMap.put(keyName[i], new TreeSet<>());
            }
            String[] time = keyTime[i].split(":");
            int min = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            freMap.get(keyName[i]).add(min);
        }
            Set<String> res = new TreeSet<>();
            for (Map.Entry<String, TreeSet<Integer>>  m : freMap.entrySet()){
                List <Integer> timeList = new ArrayList<>(m.getValue());
                 //iterate and get difference
                for (int i =2;i< timeList.size();i++){
                    if (timeList.get(i)- timeList.get(i-2) <=60){
                        res.add(m.getKey());
                        break;
                    }
                }
            }
            return new ArrayList<>(res);
    }
    public static void main(String[] args) {
        String [] names = {"daniel","daniel","daniel","luis","luis","luis","luis"};
        String [] time = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        System.out.println(alertNames(names,time));
    }
}
