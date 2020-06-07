package javalang.dp;

public class TrappingRainWater {
    // 42. Trapping Rain Water
// https://leetcode.com/problems/trapping-rain-water/

    class Solution {

        // this entire problem lies on the realization that the water at any point is ((min of Max on each side) - height at currrent point)
        // on first pass we create left max array and right max array
        // on second pass, at every point, calculate rain water
        // time = 2N space = N
        // there is a better N time 1 Spaca solution here: https://leetcode.com/problems/trapping-rain-water/discuss/17386/Sharing-my-Java-code%3A-O(n)-time-O(1)-space
        public int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int n = height.length;

            int[] left = new int[n];
            int[] right = new int[n];

            // hardcode the edge conditions for first and last element since limits on outof bounds are 0.
            left[0] = 0;
            right[n - 1] = 0;

            int leftMax = height[0], rightMax = height[n - 1];

            for (int i = 1; i < n; i++) {
                leftMax = Math.max(height[i], leftMax);
                rightMax = Math.max(height[n - i - 1], rightMax);

                left[i] = leftMax;
                right[n - i - 1] = rightMax;
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                int curr = Math.min(left[i], right[i]) - height[i];

                if (curr > 0) {
                    result += curr;
                }
            }

            return result;
        }
    }
}
