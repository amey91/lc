package javasolutions;

// #268. Missing Number
// https://leetcode.com/problems/missing-number/

public class MissingNumber {
    class Solution {
        public int missingNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int sum = (nums.length)*(nums.length+1)/2;
            for (int num : nums) {
                sum -= num;
            }
            return sum;
        }
    }
}
