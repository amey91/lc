package javalang;

// #213 https://leetcode.com/problems/house-robber-ii/

import javafx.util.Pair;

// This solution iterates once forward and once backward, but the thing is I can just iterate forward twice!!!!
public class HouseRobber2 {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length==0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            if (nums.length == 3) {
                return Math.max(Math.max(nums[0], nums[1]), nums[2]);
            }

            // take 2 rounds, one from start to end and then from end to start, and then return max
            int[] forward = new int[nums.length];
            forward[0] = nums[0];
            forward[1] = Math.max(nums[0], nums[1]);
            int[] reverse = new int[nums.length];
            reverse[nums.length-1] = nums[nums.length-1];
            reverse[nums.length-2] = Math.max(nums[nums.length-2], nums[nums.length-1]);

            // omit last one
            // 1, 2, 4
            for (int i=2; i<nums.length-1; i++) {
                forward[i] = Math.max(nums[i] + forward[i-2], forward[i-1]);
            }

            // omit first one
            // ... , 3, 1
            for (int i=nums.length-3; i>=1; i--){
                reverse[i] = Math.max(reverse[i+1], nums[i] + reverse[i+2]);
            }

            // forward excludes last element and reverse excludes first element
            return Math.max(forward[nums.length-2], reverse[1]);
        }
    }
}
