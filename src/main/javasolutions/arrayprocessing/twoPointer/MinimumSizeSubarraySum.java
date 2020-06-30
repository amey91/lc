package javasolutions.arrayprocessing.twoPointer;

public class MinimumSizeSubarraySum {
    // 209. Minimum Size Subarray Sum
// https://leetcode.com/problems/minimum-size-subarray-sum/
// Medium

    class Solution {

        // 2 pointers algo
        // maintain right and left pointers. Right increases current array and left decreases it
        // when sum becomes >= s then start decreasing the array and keep maintian min length that satisfies the conditions
        // space = 1
        // time = N
        public int minSubArrayLen(int s, int[] nums) {
            if (nums == null) {
                return 0;
            }

            int length = -1; // avoid using MAX_VALUE to prevent weird logic bugs
            int left = 0;
            int right = 0;
            int runningSum = 0;
            while (right < nums.length) {
                runningSum += nums[right];

                // start decreasing current subarray if sum is satisfactory
                // IMPORTANT: I did mistake where I said left<right in the condition here. We actually want <= since one digit can be euqal to sum as well
                // Also, its okay if left crosses right in this solution!
                while (runningSum >= s && left <= right) {
                    if (length == -1 || length > right - left + 1) {
                        // we are inside condition satisfied block so this is always correct at this point in the code
                        length = right - left + 1;
                    }
                    runningSum -= nums[left];
                    left++;
                }
                right++;
            }

            return length == -1 ? 0 : length;
        }
    }
}
