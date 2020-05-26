package javalang;

// #41. First Missing Positive
// https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 1;
            }

            // missing number must lie between 1 to n-1
            int n = nums.length;

            // IMP: remove all complexity by replacing out of bounds numbers by n+1 which is also out of bounds.
            // This simplifies handling of negative and zero numbers
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= 0 || nums[i] > n) {
                    nums[i] = n+1;
                }
            }

            // similar to bucket sort but we mark nums[index] to negative instead of bucketizing
            for (int i = 0; i < nums.length; i++) {
                int number = Math.abs(nums[i]);
                if (number > n) {
                    continue;
                }
                if (number-1 >= 0 && number-1 <= n) {
                    nums[number - 1] = -Math.abs(nums[number - 1]);
                }
            }

            // return first positive number
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return nums.length+1;
        }
    }
}

// initial algo: ( I simplified it later)
// window = 1 to n
// indexes = 0 o n-1
// for each number, index:
//     if number == 0 then set it to (n+1)
//     if number < 0
//         if Math.abs(number) > n continue
//         else nums[Math.abs(number - 1)] = (is that number negative or zero? set to -(n+1) or set to negative to itself)
//     if number > 0
//         if Math.abs(number) > n continue
//         else (number <= n) nums[num-1] = (is that number negative or zero? set to -(n+1) or set to negative to itself)
// return first number > 0
