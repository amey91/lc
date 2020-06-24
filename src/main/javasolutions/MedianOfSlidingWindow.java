package javasolutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

// https://leetcode.com/problems/sliding-window-median/

/**
 * 2 TreeSet implementation vs 2 PrioritySet implementation
 * |  add   |  remove |    peek   |
 * TreeSet     | logn   |  logn   |    logn   |
 * PrioritySet | logn   |    n    |    1      |
 * <p>
 * treeset peek is log n because findFirst() findLast() iterates through the set
 * <p>
 * priority set remove is n because it is backed by an array, so it finds it first then removes it
 * <p>
 * Thus, in hindsight, this program is better solved by tree set because of (n iterations) of (add + remove + peek)
 */

public class MedianOfSlidingWindow {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().medianSlidingWindow(new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2}, 3)));
    }

    // 2 tree set solution
    static class Solution {
        class Pair {
            int val;
            int index;

            public Pair(int val, int index) {
                this.val =  val;
                this.index = index;
            }
        }

        public double[] medianSlidingWindow(int[] nums, int k) {
            double[] slidingMedians = new double[nums.length - k + 1];

            TreeSet<Pair> minTreeSet = new TreeSet<>(
                    Comparator.<Pair>comparingInt(pair -> pair.val).thenComparing(pair -> pair.index));
            TreeSet<Pair> maxTreeSet = new TreeSet<>(
                    Comparator.<Pair>comparingInt(pair -> pair.val).thenComparing(pair -> pair.index)
            );
            for (int i = 0; i < k; i++) {
                addValue(nums[i], i, maxTreeSet, minTreeSet);
            }
            slidingMedians[0] = calculateMedian(maxTreeSet, minTreeSet);
            for (int i = 0; i <= nums.length - k - 1; i++) {
                int newInt = nums[i + k];
                int oldInt = nums[i];
                addValue(newInt, i + k, maxTreeSet, minTreeSet);
                removeValue(oldInt, i, maxTreeSet, minTreeSet);
                slidingMedians[i + 1] = calculateMedian(maxTreeSet, minTreeSet);
            }
            return slidingMedians;
        }

        private double calculateMedian(TreeSet<Pair> maxTreeSet, TreeSet<Pair> minTreeSet) {
            if ((maxTreeSet.size() + minTreeSet.size()) % 2 == 0) {
                return (maxTreeSet.last().val * 1.0 + minTreeSet.first().val) / 2.0;
            }
            return maxTreeSet.last().val;
        }

        private void removeValue(int num, int index, TreeSet<Pair> maxTreeSet, TreeSet<Pair> minTreeSet) {
            Pair pairToRemove = new Pair(num, index);
            if (maxTreeSet.contains(pairToRemove)) {
                maxTreeSet.remove(pairToRemove);
            } else {
                minTreeSet.remove(pairToRemove);
            }
            balance(maxTreeSet, minTreeSet);
        }

        private void addValue(int num, int index, TreeSet<Pair> maxHeap, TreeSet<Pair> minHeap) {
            if (maxHeap.isEmpty() || maxHeap.last().val >= num) {
                maxHeap.add(new Pair(num, index));
            } else {
                minHeap.add(new Pair(num, index));
            }

            balance(maxHeap, minHeap);
        }

        private void balance(TreeSet<Pair> maxHeap, TreeSet<Pair> minHeap) {
            // only 1 remove is sufficient since we are adding one digit at a time, otherwise I would add a while loop here
            if (maxHeap.size() > minHeap.size() + 1) {
                // max heap is ahead by >= 2 of min heap
                minHeap.add(maxHeap.pollLast());
            }
            if (maxHeap.size() < minHeap.size()) {
                // min heap is greater in size
                maxHeap.add(minHeap.pollFirst());
            }
        }
    }
}

//[-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648]
//
//[-2147483648.00000,-0.50000,-0.50000,-2147483648.00000,-2147483648.00000,-0.50000,2147483647.00000,2147483647.00000,2147483647.00000,2147483647.00000,2147483647.00000,2147483647.00000]
//[-2147483648.00000,-0.50000,-0.50000,-2147483648.00000,-2147483648.00000,-0.50000,2147483647.00000,2147483647.00000,2147483647.00000,-0.50000,-0.50000,-0.50000]


//    // 2 priority queues
//    // time for add () = logn
//    // time for delete = n // priority queue
//    // time for median = 1
//    // space = n
//    class Solution {
//        public double[] medianSlidingWindow(int[] nums, int k) {
//
//            if(nums == null || nums.length == 0 || k == 0 || nums.length < k){
//                return new double[0];
//            }
//
//            double[] slidingMedians = new double[nums.length - k + 1];
//            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
//            for (int i = 0; i < k; i++) {
//                addValue(nums[i], maxHeap, minHeap);
//            }
//            slidingMedians[0] = calculateMedian(maxHeap, minHeap);
//            for (int i = 0; i <= nums.length - k - 1; i++) {
//                int newInt = nums[i + k];
//                int oldInt = nums[i];
//                addValue(newInt, maxHeap, minHeap);
//                removeValue(oldInt, maxHeap, minHeap);
//                slidingMedians[i+1] = calculateMedian(maxHeap, minHeap);
//            }
//
//            return slidingMedians;
//        }
//
//        private double calculateMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
//            if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
//                return (maxHeap.peek() * 1.0 + minHeap.peek()) / 2.0;
//            }
//            return maxHeap.peek();
//        }
//
//        private void removeValue(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
//            if (num <= maxHeap.peek()) {
//                maxHeap.remove(num);
//            } else {
//                minHeap.remove(num);
//            }
//            balance(maxHeap, minHeap);
//        }
//
//        private void addValue(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
//            if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
//                maxHeap.add(num);
//            } else {
//                minHeap.add(num);
//            }
//
//            balance(maxHeap, minHeap);
//        }
//
//        private void balance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
//            // only 1 remove is sufficient since we are adding one digit at a time, otherwise I would add a while loop here
//            if (maxHeap.size() > minHeap.size() + 1) {
//                // max heap is ahead by >= 2 of min heap
//                minHeap.add(maxHeap.remove());
//            }
//            if (maxHeap.size() < minHeap.size()) {
//                // min heap is greater in size
//                maxHeap.add(minHeap.remove());
//            }
//        }
//    }
