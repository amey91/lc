package javalang;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    // 128. Longest Consecutive Sequence
// https://leetcode.com/problems/longest-consecutive-sequence/
    class Solution {

        public int longestConsecutive(int[] nums) {

            if (nums == null || nums.length == 0) {
                return 0;
            }

            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int maxLength = 1;
            for (int i : set) {
                if (!set.contains(i - 1)) {
                    int currLength = 1;
                    while (set.contains(i + 1)) {
                        i = i + 1;
                        currLength++;
                    }
                    maxLength = Math.max(maxLength, currLength);
                }
            }
            return maxLength;

        }

//        // Sort in place
//        // time = O(nlong) spac e= O(1)
//        public int longestConsecutive_sort(int[] nums) {
//            if (nums == null || nums.length == 0) {
//                return 0;
//            }
//            Arrays.sort(nums);
//            // 0 1 1 2
//            int left = 0;
//            int length = 1;
//            int currLength = 1;
//            for (int right = 1; right < nums.length; right++) {
//                if (nums[right] == nums[right - 1] + 1) {
//                    // series incremented
//                    currLength++;
//                } else if (nums[right] == nums[right - 1]) {
//                    // series was not broken and series length did not change
//                    continue;
//                } else {
//                    // new series starts from current position
//                    currLength = 1;
//                }
//                length = Math.max(length, currLength);
//            }
//            return length;
//        }
    }
}
