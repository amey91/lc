package javalang.arrayprocessing;

import java.util.Arrays;

public class MoveZeroes {
    // 283. Move Zeroes
// https://leetcode.com/problems/move-zeroes/

    class Solution {
        // space = 1
        // time = n
        // maintain 2 pointers, left and right. Keep mocing right pointer element to left pointer if it is not zero. If it is zero, keep track of how many zeroes to fill in the end
        public void moveZeroes(int[] nums) {
            // 2 1 0 0 1 3 4 0
            int left = 0; // 2

            while (left < nums.length && nums[left] != 0) {
                left++;
            }

            if (left == nums.length) {
                return;
            }

            // at least one zero was found
            int zeroCount = 1;

            for (int right = left + 1; right < nums.length; ) {
                if (nums[right] == 0) {
                    zeroCount++;
                    right++;
                } else {
                    nums[left++] = nums[right++];
                }
            }

            if (zeroCount > 0) {
                Arrays.fill(nums, nums.length - zeroCount, nums.length, 0);
            }

        }
    }
}
