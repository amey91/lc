package javalang;

public class TwoSum2InputArraySorted {

    // 167. Two Sum II - Input array is sorted
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] result = new int[2];
            if (numbers == null || numbers.length < 2) {
                return result;
            }

            int left = 0;
            int right = numbers.length - 1;

            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    result[0] = left + 1;
                    result[1] = right + 1;
                    return result;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return result;
        }
    }
}
