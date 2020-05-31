package javalang;

public class LongestTurbulentSubarray {
    class Solution {
        // 978. Longest Turbulent Subarray
        // https://leetcode.com/problems/longest-turbulent-subarray/

        // simple iteration

        // O(N) time and O(1) space
        public int maxTurbulenceSize(int[] A) {
            if (A== null || A.length == 0) {
                return 0;
            }

            int length = 1;
            int maxLength = 1;
            int compare = Integer.MIN_VALUE; // dont care

            for (int i = 1; i < A.length; i++) {
                int newCompare =  Integer.compare(A[i-1], A[i]);
                if (newCompare == 0) { // same umber so length is 1
                    length = 1;
                } else if (newCompare == compare) { // same turbulence, so drop previous turbeluence
                    length = 2;
                } else { // different turbulence
                    length += 1;
                }

                // update all counters
                compare = newCompare;
                maxLength = length > maxLength? length: maxLength; // quicker than MAth.max for 100% percentile
            }
            return maxLength;
        }
    }
}
