package javalang;

public class FindTheDuplicateNumber {
    // https://leetcode.com/problems/find-the-duplicate-number/submissions/
// #287. Find the Duplicate Number
    class Solution {
        public int findDuplicate(int[] nums) {
            if (nums == null || nums.length < 2) {
                return 0;
            }

            for (int number : nums) {
                if (number < 0 ) {
                    number = -number;
                }
                if (nums[number-1] < 0) {
                    return number;
                }
                nums[number-1] = -nums[number-1];
            }
            return -1;
        }
    }


// 1 3 4 2 2

// for each number in nums:
//     // todo number can be negative
//     if (number < 0 ) number = -number;
//     if (nums[number-1] < 0) {
//         return number;
//     }
//     nums[number-1] = -nums[number-1]

}
