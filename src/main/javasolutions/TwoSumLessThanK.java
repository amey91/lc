package javasolutions;

import java.util.Arrays;

public class TwoSumLessThanK {
    // 1099. Two Sum Less Than K
// https://leetcode.com/problems/two-sum-less-than-k/
    class Solution {
        public int twoSumLessThanK(int[] A, int K) {
            if (A == null || A.length < 2) {
                return -1;
            }

            Arrays.sort(A);

            int left = 0;
            int right = A.length - 1;
            Integer max = -1;

            // keep going until pointers cross, since there can be more than one solutions <K
            while (left < right) {
                int sum = A[left] + A[right];
                if (sum < K) {
                    max = Integer.max(max, sum);
                }
                if (K <= sum) {
                    right--;
                } else {
                    left++;
                }
            }

            return max;
        }
    }
}
