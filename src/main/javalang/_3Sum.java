package javalang;

import java.util.*;

public class _3Sum {
    // 15. 3Sum
    //    https://leetcode.com/problems/3sum/

    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        // we sort first then iterate over array once. For each element, we need to parse the others and find 2Sum in remaining
        // N for outer loop, N for sorted 2Sum = N^2 time
        // 1 space
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null) {
                return result;
            }

            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                // prevent duplicates in first number in solution
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target = 0;
                do2Sum(nums, target - nums[i], i + 1, nums.length - 1);
            }
            return result;
        }

        private void do2Sum(int[] nums, int target, int start, int end) {
            if (start >= end) {
                return;
            }
            // for recodring answer, can also be passed into this method as param
            int currIndex = start - 1;

            while (start < end) {
                if (nums[start] + nums[end] == target) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[currIndex]);
                    l.add(nums[start]);
                    l.add(nums[end]);
                    result.add(l);

                    // IMPORTANT: prevent duplicates inside the trio!!
                    start++;
                    end--;
                    // if the start **AND** new start are the same as previous numbers in solution, skip duplicate in answer
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++; // its enough to skip only one number of the two since trio is broken
                    }
                } else if (nums[start] + nums[end] > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
    }
}