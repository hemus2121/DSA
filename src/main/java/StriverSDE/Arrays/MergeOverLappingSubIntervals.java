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
            if ( i[0] <= end){ // incoming interval start is less than curren end
                end  = Math.max(end, i[1]);  // get the maximum end
            }else {
                // no overlapping to add to result and revise start, end values
                resList.add (new int []{ start, end});
                start = i[0];
                end = i[1];
            }
        }
        resList.add(new int []{start,end}); // add the last start and end values
        return resList.toArray(new int [resList.size()][1]);
    }
    public static void main(String[] args) {
        int [][] data = { {1,3},{2,4},{2,6},{8,9},{8,10}, {9,11},{15,18},{16,17}};
        mergeInterval(data);
        System.out.println(Arrays.toString(data));
    }
}
