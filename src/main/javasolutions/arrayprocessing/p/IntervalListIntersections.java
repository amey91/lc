package javasolutions.arrayprocessing.p;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    // 986. Interval List Intersections
// https://leetcode.com/problems/interval-list-intersections/
    class Solution {

        // move over both arrays at a time and find the intersection pair
        // if pair is valid, then add it to result
        // space = 1 (+ N for storing answer)
        // time = N
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            List<int[]> list = new ArrayList<>();
            int i = 0;
            int j = 0;

            while (i < A.length && j < B.length) {

                // Note this can be easily derived by enumerating the permutations of windows quickly
                // look at https://github.com/amey91/leetcode/blob/a4c449bc9a8fa9adb5694a251eaab8616d05e1aa/src/main/javalang/arrayprocessing/p/IntervalListIntersections.JPG

                int min = Math.max(A[i][0], B[j][0]);
                int max = Math.min(A[i][1], B[j][1]);

                // IMPORTANT equal bounds are also allowed in this question
                if (min <= max) {
                    list.add(new int[]{min, max});
                }

                // move higher endpoint to next element
                if (A[i][1] < B[j][1]) {
                    i++;
                } else {
                    j++;
                }
            }

            return list.toArray(new int[0][]);
        }
    }
}
