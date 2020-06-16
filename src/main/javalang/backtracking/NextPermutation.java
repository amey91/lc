package javalang.backtracking;

import java.util.Arrays;

public class NextPermutation {

    // https://leetcode.com/problems/next-permutation/
// 31. Next Permutation
    class Solution {

        // LEXICOGRAPHIC arrangement for next increasing sequence
        // We use simple logic here instead of bracktracking
        // Next lexicographic permutation will start from right element i where (i) < (i+1)
        // Swap this i with the least greatest element from its right that we already parsed in above step
        // After swapping, we sort the array after i index because we want least lexicographic permutation
        // space = 1
        // time = N for finding lexicographic candidate + N for next greater element + N sorting end of the array = N
        public void nextPermutation(int[] nums) {

            if (nums == null) {
                return;
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                if (i == 0) {
                    // array is decreasing, so no next lexicographically greater permutation
                    // TODO: we can write our own implmeentation for sort in N time since the array is strictly decreasing, so just interchaning positions will run in N time instead of NlogN here
                    Arrays.sort(nums);
                    return;
                }
                if (nums[i] > nums[i - 1]) { // found a number that can be next in lexicographic order
                    int toSwap = i - 1;

                    // find next lexicographic successor i.e. least greatest number than current number. There is at least one element greater than current one because we searched for this number using (nums[i] > nums[i-1])
                    int nextGreaterIndex = toSwap + 1;
                    for (int j = toSwap + 1; j < nums.length; j++) {
                        if (nums[j] <= nums[toSwap]) {
                            break;
                        }
                        nextGreaterIndex = j;
                    }

                    swap(nums, toSwap, nextGreaterIndex);

                    // now sort the array beginning from (toSwap+1) because we need lexicographic successor
                    Arrays.sort(nums, toSwap + 1, nums.length);
                    return;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int swapTemp = nums[i];
            nums[i] = nums[j];
            nums[j] = swapTemp;
        }


        // OPTIONAL - other INTUITION from other premutations problems
        // this approaches the sum from point of view of solution for Permutations under https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
        // this approach iterates over the array at all N levels and if the current number is present in the current solution, it skips that loop
        // e.g. 132 where there are 3 levels of recursion, 1st level is running for 1, second level for 3 and third level for 2
        // since the third level will run for 3 and see that 3 is already in list, the recursion goes to level 1 and increments
        // the first element to be 2. So next sequence is 213!
    }
}
