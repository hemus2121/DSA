package Visa.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int [] > resultList = new ArrayList<>();
        //edge case
        if (intervals == null || intervals.length==0){
            return  resultList.toArray(new int[0][]);
        }

        //sort array based on 1st attribute
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        // start point
        int start = intervals[0][0];
        int end = intervals[0][1];

        //iterate other once
        for (int [] i : intervals){
            if (i[0] < end){
                end = Math.max(end, i[0]);
            }
            else {
                //add the current interval
                resultList.add(new int []{ start, end});
                //initialize next set of interval as beginning for comparison
                start = i[0];
                end = i[1];

            }
        }
        resultList.add(new int []{start,end});
        return resultList.toArray(new int [0][1]);
    }
}
