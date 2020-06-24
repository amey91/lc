package javasolutions.arrayprocessing;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    class Solution {

        // maintain a running sum and make use of the fact (a+b)%k = a%k + b%k so that we can modulo each running sum
        // if the current runningsum after modulo is seen before, that means that the numbers in running sum between the indexes that produced the same mod values had a sum of x*K.
        // there is a special edge case around the "continuous subarray of size at least 2" produced by 0 and k entries in the array and these condition are noted in the comments
        // space = N
        // time = k since we only keep %k values in the set!
        public boolean checkSubarraySum(int[] nums, int k) {

            if (nums == null) {
                return false;
            }

            Map<Integer, Integer> sums = new HashMap<>();

            int runningSum = 0;

            // sums.put(0, -1);
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                runningSum += n;
                if (k != 0) {
                    runningSum %= k;
                }


                // if a number is followed by 6 or 0, the next modulo does not change, which is okay
                // however, if there are several 0s in sequence, it is still fine to have consecutive zeroes and the solution should still work
                // e.g. consider 5, 2, 4 and k = 6. The moduloes look like 5, 1, 5 and there need to be atleast 2 numbers processed between both moduloes
                // in the case of 0, 0 and k = 0, the moduloes are 0,0 but the solution is still valid, even though the indexes are next to each other. so we add 0,-1 to fix this condition
                sums.put(0, -1);
                if (sums.containsKey(runningSum)) {

                    // the modulo numbers cannot be adjacent to each other, so difference in indexes must be at least 2.
                    // special conditions are 6 and 0/
                    if (i - sums.get(runningSum) >= 2) {
                        return true;
                    }
                } else {
                    sums.put(runningSum, i);
                }
            }

            return false;
        }
    }
}
