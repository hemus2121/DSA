package Scal.Arrays;

import java.util.ArrayList;
import java.util.Collections;

/*
Problem Description
Given a collection of intervals, merge all overlapping intervals.
Input 1:
[1,3],[2,6],[8,10],[15,18]
 */
public class MergeOverLappingInterval {
    static class Interval{
        int start, end;
        Interval(int s, int e){
            this.start =s;
            this.end =e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +  '}';
        }
    }
    public static ArrayList<Interval> mergeInterval(ArrayList<Interval> intervals) {

        //response place holder
        ArrayList<Interval> responseList = new ArrayList<>();

        //Sort the intervals to be ascending order based ib start values
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        //Add the first interval to begin with
        Interval curr = intervals.get(0);
        responseList.add(curr);

        //iterate for next interval
        for (int i =1; i< intervals.size();i++){
            int next_start = intervals.get(i).start;
            int next_end = intervals.get(i).end;

            //check condition to merge - incoming interval start < current interval end
            if ( next_start < curr.end){
                curr.end = Math.max( curr.end, next_end);
            }else{
                responseList.add(intervals.get(i));
            }
        }
        return responseList;
    }
    public static void main(String[] args) {
        ArrayList <Interval> existingInterval = new ArrayList<>();
        existingInterval.add(new Interval(1, 3));
        existingInterval.add(new Interval(2, 6));
        existingInterval.add(new Interval(8, 10));
        existingInterval.add(new Interval(15, 18));
        System.out.println(mergeInterval(existingInterval));
    }
}
