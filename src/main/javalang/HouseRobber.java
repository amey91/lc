package javalang;

// #198 https://leetcode.com/problems/house-robber/
// constant space (in-place replacement) and n time
public class HouseRobber {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            nums[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
            }
            return nums[nums.length - 1];
        }
    }
}


// first solution
// This memoizes 2 variables, 1. the optimum sum after including current value, 2. the optimum sum excluding current value till now.
// This is not needed since we need not store both values. It is enough if we just store the optimum value till now
// The optimum value considers both include and does not include, and thus stores the optimal solution till that point in time.
// Thus will change the solution to use just 1 optimal solution values instead of 2. This is still same n time and space, but in absolute terms,
// it eliminates half the space needed in this solution.
class Solution1 {
    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        // pos to (include, dont't include)
        int[][] memoize = new int[nums.length][2];

        memoize[nums.length-1][0] = nums[nums.length-1];
        memoize[nums.length-1][1] = 0;

        for (int i= nums.length-2; i>=0; i--) {
            memoize[i][1] = Math.max(memoize[i+1][1], memoize[i+1][0]);
            memoize[i][0] = nums[i] + memoize[i+1][1];
        }

        return Math.max(memoize[0][0], memoize[0][1]);
    }
}