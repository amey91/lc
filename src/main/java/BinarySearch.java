package main.java;

public class BinarySearch {

    // https://leetcode.com/problems/binary-search/
//  704. Binary Search
    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null) {
                return -1;
            }

            int l = 0; int r = nums.length-1;
            int p;
            while (l <= r) {
                p = (l+r)/2;
                if (nums[p] == target) {
                    return p;
                }
                if (nums[p] < target) {
                    l = p+1;
                } else {
                    r = p-1;
                }
            }
            return -1;
        }
    }
}
