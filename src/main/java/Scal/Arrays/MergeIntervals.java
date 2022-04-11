package Scal.Arrays;

import java.util.ArrayList;

/*Problem Description

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Input 1:
Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
 */
public class MergeIntervals {

    static class Interval{
        int start, end;
        Interval(int s, int e) { start =s; end=e; };
    }
    static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        //result list
        ArrayList<Interval> resultList = new ArrayList<>();
        int n = intervals.size();
        int cur =0;

        // Case 1 : copy 1st half of non overlapping intervals- it check whether new interval comes before current interval
        while (cur < n  &&  intervals.get(cur).end < newInterval.start){
            resultList.add(intervals.get(cur));
            cur++;
        }

        // Case 2 : check for overlapping intervals- check until current intervals start < new interval end
        while (cur < n && intervals.get(cur).start <= newInterval.end){
            newInterval.start= Math.min(intervals.get(cur).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(cur).end, newInterval.end);
            cur++;
        }
        resultList.add(newInterval);

        // case 3 : copy remaining intervals which r not overlapping
        while (cur <n){
            resultList.add( intervals.get(cur));
            cur++;
        }
        return  resultList;
    }

    public static void main(String[] args) {
        ArrayList <Interval> existingInterval = new ArrayList<>();
        existingInterval.add(new Interval(1, 3));
        existingInterval.add(new Interval(6, 9));
        System.out.println(insert(existingInterval, new Interval(2, 5)));

    }
}
