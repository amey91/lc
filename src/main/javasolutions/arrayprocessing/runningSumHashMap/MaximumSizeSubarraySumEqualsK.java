package javasolutions.arrayprocessing.runningSumHashMap;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {
    // 325. Maximum Size Subarray Sum Equals k
// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
// Medium

    class Solution {

        // Keep runinng sum and the sum between ith and jth indexes can be calculated using sum[j]-sum[i-1]
        // We can say that difference between two runningSUms == k then numbers between those 2 indexes sum upto k
        // We keep a hashmap of the running sums so that we can find the sums immediately without havinf to re-iterate teh sums array
        // This reduces complexity from N^2 to N
        // space = N
        // time = N
        public int maxSubArrayLen(int[] nums, int k) {
            // get running sums
            // store running sums in a hashmap sum->index // keep the first index since we want biggest array
            // for each sum in running sums, see if k-a exists in the map. If it does, try to update maxLength
            // return maxLegnth

            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            int[] sums = new int[n];
            int runningSum = 0;
            Map<Integer, Integer> sumToIndex = new HashMap<>();


            // IMPORTANT this is required so that we calculate the length correctly for solutions that begin from index 0 e.g. -2,-1,2,1 and k = 0
            sumToIndex.put(0, -1);
            for (int i = 0; i < n; i++) {
                runningSum += nums[i];
                sums[i] = runningSum;

                // IMPORTANT: dont override previous index since we need max length
                if (!sumToIndex.containsKey(runningSum)) {
                    sumToIndex.put(runningSum, i);
                }
            }

            int max = -1;
            for (int i = 0; i < n; i++) {
                // currSum - prevSum = k
                // thus, prevSum = surrSum - k
                // also check for larger index only
                if (sumToIndex.containsKey(sums[i] - k) && i > sumToIndex.get(sums[i] - k)) {
                    max = Math.max(max, Math.abs(i - sumToIndex.get(sums[i] - k)));

                }
            }

            return max == -1 ? 0 : max;
        }
    }
}
