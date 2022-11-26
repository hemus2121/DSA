package Visa.Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 */
//https://leetcode.com/problems/meeting-rooms-ii/discuss/1068957/Java-min-heap-w-explanation

public class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, ( a,b) -> (a[0]-b[0]));

        //Minimum heap, used to track meeting end times.
        //Meetings get added to heap when they start, and are removed once done.
        //The size of the heap tells us the number of meetings going on at present.
        PriorityQueue<Integer> curMeetings = new PriorityQueue<>();

        int maxRooms =0;
        for (int i =0;i< intervals.length;i++){
            int startTime =intervals[i][0];
            int endTime = intervals[i][1];

            //Meetings that end before or at the same time as current meeting starts, need to 'release' their rooms.
            while (curMeetings.size() >0 && curMeetings.peek()<= startTime){
                curMeetings.remove();
            }
            //Current meeting occupies a room. Add current meeting's end time to heap.
            curMeetings.add(endTime);
            //update result
            maxRooms = Math.max(maxRooms, curMeetings.size());
        }
        return maxRooms;
    }

}
