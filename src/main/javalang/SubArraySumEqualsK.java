package javalang;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    // 560. Subarray Sum Equals K
// https://leetcode.com/problems/subarray-sum-equals-k/

    class Solution {

        // maintain a running sum and for each running sum, see how many times we have seen (runningSum - k)
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0, runningSum = 0;

            // IMP: you forgot this! run through the program once and realize that for [1,1,1] and k = 1, you would count one less for first 1
            map.put(0, 1);
            for (int i : nums) {

                // only past runningSums that have runningSum-k matter difference between both subarrays is exactly k!
                // suppose runningsums = [ ... n... m ... ]
                // thus m - n = k i.e. n = m - k
                runningSum += i;
                if (map.containsKey(runningSum - k)) {
                    count += map.get(runningSum - k);
                }
                map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
            }
            return count;
        }

//     // O(N^2) time and O(1) space
//     public int subarraySum_iteration(int[] nums, int k) {
//         if (nums == null) {
//             return 0;
//         }

//         int count = 0;
//         for (int i = 0; i< nums.length; i++) { // 1
//             int currSum = 0;
//             for (int j = i; j< nums.length; j++) { // 2
//                 currSum += nums[j];
//                 if (currSum == k) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }

//     // O(N^2) time and O(n) space by using optimized DP
//     public int subarraySum_dp(int[] nums, int k) {
//         if (nums == null) {
//             return 0;
//         }

//         int count = 0;
//         int n = nums.length;
//         int[] prev = new int[n];

//         for (int i = 0; i< n; i++) {
//             int[] next = new int[n];

//             for (int j = i; j < n; j++) {
//                 if (i == j) {
//                     next[j] = nums[j];
//                 } else {
//                     next[j] = nums[j] + prev[j-1];
//                 }
//                 if (next[j] == k) {
//                     count++;
//                 }
//                 prev = next;
//             }
//         }

//         return count;
//     }
    }
}
