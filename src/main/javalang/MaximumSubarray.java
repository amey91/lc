package javalang;

public class MaximumSubarray {

    // 53. Maximum Subarray
//    https://leetcode.com/problems/maximum-subarray/

    class Solution {

        // without DP array, so runs in constant space and linear time
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int max = nums[0], sum = nums[0];

            for (int i = 1; i < nums.length; i++) {
                // if the previous sum takes anything away from the current number, drop the previous sum
                sum = Math.max(nums[i], sum + nums[i]);
                max = sum > max ? sum : max; // seems to be faster than Math.max
            }

            return max;
        }

//     public int maxSubArray_withDPArray(int[] nums) {
//         if (nums == null || nums.length == 0) {
//             return 0;
//         }
//         int[] dp = new int[nums.length];
//         int max = nums[0];
//         int sum = nums[0];
//         dp[0] = nums[0];

//         for (int i = 1; i < nums.length; i++) {
//             sum = Math.max(nums[i] + dp[i-1], nums[i]);
//             dp[i] = sum;
//             max = Math.max(max, sum);
//         }

//         return max;
//     }
    }
}
