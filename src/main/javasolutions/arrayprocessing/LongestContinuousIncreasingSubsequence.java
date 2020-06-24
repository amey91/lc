package javasolutions.arrayprocessing;

public class LongestContinuousIncreasingSubsequence {
    // 674. Longest Continuous Increasing Subsequence
    // https://leetcode.com/problems/longest-continuous-increasing-subsequence/
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            // 1 2 3 2 1
            // 1
            // []
            // 1 2 3 4
            // 5 4 3 2 1
            // 2 2 2
            int lastMinIndex = 0;
            int lastMinLength = 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] <= nums[i - 1]) {
                    lastMinIndex = i;
                }
                lastMinLength = Math.max(lastMinLength, i - lastMinIndex + 1);
            }
            return lastMinLength;
        }
    }
}
