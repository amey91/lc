package javasolutions.arrayprocessing;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    // 57. Insert Interval
// https://leetcode.com/problems/insert-interval/

    class Solution {

        // IMPORTANT: for solving this problem, I was looking at enumerating situations where there is overlap
        // However, the trick to solving this efficiently is to enumerate conditions where there is no overlap and then treat all remaining conditions as ones with overlap!
        // Also remember to handle last unmerged interval into list
        // time N
        // space N
        public int[][] insert(int[][] intervals, int[] newInterval) {
            // algo:
            // newInterval smaller than current interval then add everything to result and return
            // new interval greater than current then add curr to result and move to next one
            // otherwise there is some kind of overlap
            // be careful not to drop interval at end if you reach the end

            if (intervals == null || intervals.length == 0) {
                return new int[][]{newInterval};
            }

            if (newInterval == null) {
                return intervals;
            }

            List<int[]> result = new ArrayList<>();
            for (int i = 0; i <= intervals.length; i++) {
                if (i == intervals.length) {
                    // last un-added merged interval
                    result.add(newInterval);
                } else if (newInterval[1] < intervals[i][0]) {

                    // interval to be merged is smaller than current interval
                    result.add(newInterval);

                    while (i < intervals.length) {
                        result.add(intervals[i++]);
                    }
                    return result.toArray(new int[0][]);
                } else if (newInterval[0] > intervals[i][1]) {

                    // interval to be merged is greater than current interval
                    result.add(intervals[i]);
                } else {

                    // else there is some kind of overlap!!
                    // IMPORTANT: eliminating no overlap conditions is MUCH easier than enumerating
                    // conditions with overlap!! I know of 6 conditions where there is overlap, but only 2 easy ones where there is no overlap
                    newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                }

            }

            return result.toArray(new int[0][]);
        }
    }
}
