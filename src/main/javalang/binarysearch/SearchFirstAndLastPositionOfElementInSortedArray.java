package javalang.binarysearch;

public class SearchFirstAndLastPositionOfElementInSortedArray {
    // 34. Find First and Last Position of Element in Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    class Solution {

        // algo: search left bound and right bound seaprately. At every point in search, if middle ever points to target, note that point
        // time = logN
        // space = 1
        public int[] searchRange(int[] nums, int target) {
            // left index do biinary serach till the nums[right] <= target
            // right index do binary search till nums[left] >= target

            // TODO reduce duplication between the sums
            int left = findFirst(nums, target);
            int right = findLast(nums, target);

            return new int[]{left, right};
        }

        private int findFirst(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            int index = -1;
            while (l <= r) {
                int middle = l + (r - l) / 2;

                // go left if greater than OR EQUAL to target
                if (nums[middle] >= target) {
                    r = middle - 1;
                } else {
                    l = middle + 1;
                }
                if (nums[middle] == target) {
                    index = middle;
                }
            }

            return index;
        }

        private int findLast(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            int index = -1;
            while (l <= r) {
                int middle = l + (r - l) / 2;

                // go right if less than than OR EQUAL to target
                if (nums[middle] <= target) {
                    l = middle + 1;
                } else {
                    r = middle - 1;
                }
                if (nums[middle] == target) {
                    index = middle;
                }
            }

            return index;
        }
    }
}
