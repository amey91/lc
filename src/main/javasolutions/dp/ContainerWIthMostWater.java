package javasolutions.dp;

public class ContainerWIthMostWater {
    // 11. Container With Most Water
// https://leetcode.com/problems/container-with-most-water/

    class Solution {


        // for each end left and right, the area will be (min of arr[left] and arr[right]) * distance between left and right
        // for moving the pointers, we move which ever pointer is smaller since moving the larger pointer will NOT offset the
        // loss of width in the area
        // time = N space = 1
        public int maxArea(int[] height) {

            if (height == null || height.length == 0) {
                return 0;
            }

            int max = -1;

            int left = 0;
            int right = height.length - 1;

            while (left < right) {
                int area = Math.min(height[left], height[right]) * (right - left);
                max = Math.max(max, area);

                if (height[left] >= height[right]) {
                    right--;
                } else {
                    left++;
                }
            }
            return max;

        }


        // time = N^2
        // space = 1
        // public int maxArea_nsquaredtime(int[] height) {
        //     if (height == null || height.length == 0) {
        //         return 0;
        //     }
        //     int n = height.length;
        //     int maxWater = -1;
        //     for (int i = 0; i < n ; i ++) {
        //         for (int j = i+1 ; j < n ; j++) {
        //             int water = Math.min(height[i], height[j]) * (j - i);
        //             maxWater = Math.max(water, maxWater);
        //         }
        //     }
        //     return maxWater;
        // }
    }
}
