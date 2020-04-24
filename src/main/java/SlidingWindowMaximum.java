package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;

// #239. Sliding Window Maximum

// TODO : there is a better solution which handles the sliding window numbers in the form of a linkedlist instead of priority queue
// See https://www.programcreek.com/2014/05/leetcode-sliding-window-maximum-java/
// Also see this for explanation https://www.youtube.com/watch?v=39grPZtywyQ
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || k == 0 || k > nums.length) {
            return new int[0];
        }

        if (k == 1 || nums.length == 1) {
            return nums;
        }

        int [] res = new int[nums.length - k + 1];

        PriorityQueue<Integer> window = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            window.add(nums[i]);
        }
        res[0] = window.peek();

        for (int i = 1; i <= nums.length - k; i++) {

            window.add(nums[i+k-1]);
            window.remove(nums[i - 1]);
            res[i] = window.peek();
        }
        return res;
    }
}
