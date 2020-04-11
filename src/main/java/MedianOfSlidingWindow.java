package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sliding-window-median/
public class MedianOfSlidingWindow {

    // 2 priority queues
    // time for add () = logn
    // time for delete = n // priority queue
    // time for median = 1
    // space = n
    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            double[] slidingMedians = new double[nums.length - k + 1];

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < k; i++) {
                addValue(nums[i], maxHeap, minHeap);
            }
            slidingMedians[0] = calculateMedian(maxHeap, minHeap);
            for (int i = 0; i <= nums.length - k - 1; i++) {
                int newInt = nums[i + k];
                int oldInt = nums[i];
                addValue(newInt, maxHeap, minHeap);
                removeValue(oldInt, maxHeap, minHeap);
                slidingMedians[i+1] = calculateMedian(maxHeap, minHeap);
            }
            return slidingMedians;
        }

        private double calculateMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
            if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
                return (maxHeap.peek() * 1.0 + minHeap.peek()) / 2.0;
            }
            return maxHeap.peek();
        }

        private void removeValue(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
            if (num <= maxHeap.peek()) {
                maxHeap.remove(num);
            } else {
                minHeap.remove(num);
            }
            balance(maxHeap, minHeap);
        }

        private void addValue(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            balance(maxHeap, minHeap);
        }

        private void balance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
            // only 1 remove is sufficient since we are adding one digit at a time, otherwise I would add a while loop here
            if (maxHeap.size() > minHeap.size() + 1) {
                // max heap is ahead by >= 2 of min heap
                minHeap.add(maxHeap.remove());
            }
            if (maxHeap.size() < minHeap.size()) {
                // min heap is greater in size
                maxHeap.add(minHeap.remove());
            }
        }
    }
}