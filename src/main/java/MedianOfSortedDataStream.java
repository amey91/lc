package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/
public class MedianOfSortedDataStream {
//        Solution 2 using 2 priority queues
//            time for add = O(logn) for deletion/insertion into each queue for single add in worst case
//    time for findmedian = 1


    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    Integer median;
    Integer size;

    /** initialize your data structure here. */
    public MedianOfSortedDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        median = null;
        size = 0;
    }

    public void addNum(int num) {
        if (median == null) {
            // first insertion
            median = num;
            size ++;
            return;
        }
        if (num <= median) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        size++;
        balance();
    }

    public double findMedian() {
        if (size % 2 == 0) {
            return (median + maxHeap.peek()) / 2.0;
        }
        return median == null? 0.0 : median;
    }

    private void balance() {
        if (maxHeap.size() -1 > minHeap.size()) {
            minHeap.add(median);
            median = maxHeap.remove();
            return;
        }
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(median);
            median = minHeap.remove();
        }
    }


}


//Solution 1 using DLL
//time add = O(n) for insertion sort
//time findMedian = O(1) for single access
//
//class MedianFinder {
//
//    static class ListNode {
//        public int val;
//        public ListNode next;
//        public ListNode previous;
//
//        public ListNode(int val) {
//            this.val = val;
//        }
//
//        public ListNode() {
//            this.val = -1;
//        }
//    }
//
//    ListNode head;
//    ListNode tail;
//    ListNode median;
//    int size;
//
//    /** initialize your data structure here. */
//    public MedianFinder() {
//        head = new ListNode();
//        tail = new ListNode();
//        // null -> head -> tail -> null
//        head.next = tail;
//        tail.previous = head;
//        head.previous = null;
//        tail.next = null;
//        size = 0;
//    }
//
//    public void addNum(int num) {
//        ListNode newLL = new ListNode(num);
//        size++;
//        if (head.next == tail) {
//            // first insertion
//            head.next = newLL;
//            newLL.previous = head;
//            newLL.next = tail;
//            tail.previous = newLL;
//            median = newLL;
//        } else {
//            // there are other nodes
//            ListNode curr = head.next;
//            while (curr != tail && curr.val < num) {
//                curr = curr.next;
//            }
//            ListNode penUltimate = curr.previous;
//            penUltimate.next = newLL;
//            newLL.previous = penUltimate;
//            newLL.next = curr;
//            curr.previous = newLL;
//
//            if (num <= median.val) {
//                if (size % 2 == 0) {
//                    median = median.previous;
//                }
//            } else {
//                if (size % 2 == 1) {
//                    median = median.next;
//                }
//            }
//        }
//    }
//
//    public double findMedian() {
//        if (head.next == tail) {
//            // no items to parse
//            return 0.0;
//        }
//
//        if (size % 2 == 0) {
//            // even length
//            return (median.val + median.next.val) / 2.0;
//        }
//
//        // odd length
//        return median.val;
//    }
//}
//
///**
// * Your MedianFinder object will be instantiated and called as such:
// * MedianFinder obj = new MedianFinder();
// * obj.addNum(num);
// * double param_2 = obj.findMedian();
// */