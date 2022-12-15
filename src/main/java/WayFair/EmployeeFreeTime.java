package WayFair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {

    static class Interval {
        public int start;
        public int end;

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        PriorityQueue<Interval> q = new PriorityQueue<>((a,b)-> {
            return a.start - b.start;
        });

        //Add all intervals to Queue
        for (List<Interval> list : schedule){
            q.addAll(list);
        }

        //placeholder for results
        List<Interval> res = new ArrayList();
        LinkedList<Interval> merged = new LinkedList(); // to store intervals

        while (q.isEmpty()== false){
            Interval  cur = q.poll();
            if (merged.isEmpty()){
                merged.add(cur);
            }else{
                Interval pre = merged.getLast(); // get the last element from the list
                if (pre.end < cur.start){//ṇo overlap
                    merged.add(cur); // add to list
                    res.add(new Interval(pre.end, cur.start));
                }else{
                    pre.end = Math.max(pre.end, cur.end); //extend the end
                }
            }
        }
        return  res;
    }
}
