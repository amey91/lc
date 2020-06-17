package javalang.arrayprocessing;

import java.util.Arrays;

public class SearchInRotatedSortedArray {
    // 33. Search in Rotated Sorted Array
// https://leetcode.com/problems/search-in-rotated-sorted-array/

    class Solution {


        // find pivot first and then search correct part of the array from pivot
        // time = logN + logN
        // space = 1
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int pivotIndex = findPivot(nums, 0, nums.length - 1);
            if (nums[pivotIndex] == target) {
                return pivotIndex;
            }

            int result;
            if (pivotIndex == 0) {
                result = Arrays.binarySearch(nums, 0, nums.length, target);
                // binary search function returns negative insertion index if key not found
                return result >= 0 ? result : -1;
            }

            if (target >= nums[0] && target <= nums[pivotIndex - 1]) {
                result = Arrays.binarySearch(nums, 0, pivotIndex, target);
                // binary search function returns negative insertion index if key not found
                return result >= 0 ? result : -1;
            } else {
                result = Arrays.binarySearch(nums, pivotIndex + 1, nums.length, target);
                // binary search function returns negative insertion index if key not found
                return result >= 0 ? result : -1;
            }

        }

        private int findPivot(int[] nums, int l, int r) {

            if (l == r) {
                return l;
            }

            // search has converged
            if (l + 1 == r) {
                return nums[l] > nums[r] ? r : l;
            }

            int mid = l + (r - l) / 2; //prevent overflow

            if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return mid;
            }

            // note that we did not do mid+1 and mid-1 because we might skip over the correct pivot if we do that
            // e.g. [4,5,6,7,0,1,2]
            if (nums[l] > nums[mid]) {
                return findPivot(nums, l, mid);
            } else {
                return findPivot(nums, mid, r);
            }
        }
    }
}
