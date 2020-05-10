package main.java;

public class NumberOfLongestIncreasingSubsequence {
    // https://leetcode.com/problems/number-of-longest-increasing-subsequence/
// 673. Number of Longest Increasing Subsequence
    // DP O(n^2) time
    // O(n) space

    class Solution {

        public int findNumberOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int maxLength = 0;
            int n = nums.length; // 1 3 5 4 7
            // length of max substring till that point
            int[] lengths = new int[n];
            // number of substring that lead till that point
            int[] counts = new int[n];

            for (int i = 0; i < n; i++) { // 1
                // each object is a subsequence
                lengths[i] = 1;
                // each object can be reached at least oo
                counts[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (lengths[i] < lengths[j] + 1) {
                            // new maxLength
                            lengths[i] = lengths[j] + 1;

                            // NOTE: counts can be handled separately in another loop tbut this gives better runtime
                            counts[i] = counts[j];
                        } else if (lengths[i] == lengths[j] + 1) {
                            // another length that is matching max length for this item till now
                            counts[i] += counts[j];
                        }
                    }
                }
                maxLength = Math.max(maxLength, lengths[i]);
            }
            // stop early if the sequence is not increasing
            if (maxLength == 1) {
                return nums.length;
            }


            // this can also be moved to inside the loop but keeping it here for readability
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (lengths[i] == maxLength) {
                    count += counts[i];
                }
            }
            return count;
        }
    }
}
