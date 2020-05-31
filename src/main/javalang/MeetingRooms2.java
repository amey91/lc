package javalang;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    // 253. Meeting Rooms II
// https://leetcode.com/problems/meeting-rooms-ii/

    class Solution {

        public int minMeetingRooms(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }

            // Sort the intervals by start time
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            // Use a min heap to track the minimum end time of merged intervals
            // IMP: the priority queue needs to have the minimum end at the top so that we use minimum number if rooms
            // e.g. (10, 30), (15, 35), (31, 35).
            PriorityQueue<int[]> heap = new PriorityQueue<>(intervals.length, (a, b) -> a[1] - b[1]);

            // start with the first meeting, put it to a meeting room
            heap.offer(intervals[0]);

            for (int i = 1; i < intervals.length; i++) {
                // get the meeting room that finishes earliest
                int[] interval = heap.poll();

                if (intervals[i][0] >= interval[1]) {
                    // if the current meeting starts right after
                    // there's no need for a new room, merge the interval
                    interval[1] = intervals[i][1];
                } else {
                    // otherwise, this meeting needs a new room
                    heap.offer(intervals[i]);
                }

                // don't forget to put the meeting room back.
                heap.offer(interval);
            }

            return heap.size();
        }
    }
}
