package javalang.arrayprocessing;

public class MotonicArray {
    // 896. Monotonic Array
// https://leetcode.com/problems/monotonic-array/

    class Solution {
        public boolean isMonotonic(int[] A) {
            if (A == null || A.length == 0) {
                return false;
            }
            if (A.length <= 2) {
                return true;
            }
            int i = 0;

            // goto first comparable integer
            while (i < A.length - 1 && A[i] == A[i + 1]) {
                i++;
            }

            // already at end?
            if (i == A.length - 1) {
                return true;
            }

            int compare = Integer.compare(A[i], A[i + 1]);

            for (; i < A.length - 1; i++) {
                // equal characters are allowed
                if (A[i] != A[i + 1] && Integer.compare(A[i], A[i + 1]) != compare) {
                    return false;
                }
            }

            return true;
        }
    }
}
