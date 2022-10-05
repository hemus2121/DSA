package StriverSDE.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Merge OverLapping subintervals
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeOverLappingSubIntervals {
    public static int [][] mergeInterval (int [][] intervals){
        List <int []> resList = new ArrayList();
        //boundary case
        if(intervals==null || intervals.length== 0){
            return resList.toArray(new int [0][]);
        }

        //sort based on 1st parameter of intervals
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        //Iterate for intervals
        for (int [] i : intervals){
            if ( i[0] <= end){
                end  = Math.max(end, i[1]);
            }else {
                resList.add (new int []{ start, end});
                start = i[0];
                end = i[1];
            }
        }
        resList.add(new int []{start,end});
        return resList.toArray(new int [0][1]);
    }
    public static void main(String[] args) {
        int [][] data = { {1,3},{2,6},{8,10},{15,18}};
        mergeInterval(data);
        System.out.println(Arrays.toString(data));
    }
}
