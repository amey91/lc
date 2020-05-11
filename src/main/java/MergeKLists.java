package main.java;

import main.java.commons.ListNode;

// https://leetcode.com/problems/merge-k-sorted-lists/submissions/
// 23. Merge k Sorted Lists
class MergeKLists {
    // this uses Divide and Conquer!
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        return mergeLists(lists, 0, lists.length-1);
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (right - left == 1) {
            return merge2Lists(lists[left], lists[right]);
        }
        int middle = (left + right) /2;

        ListNode leftHalf = mergeLists(lists, left, middle);
        ListNode rightHalf = mergeLists(lists, middle+1, right);
        return merge2Lists(leftHalf, rightHalf);
    }

    private ListNode merge2Lists(ListNode leftNode, ListNode rightNode) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while (leftNode != null && rightNode != null) {
            if (leftNode.val <= rightNode.val) {
                curr.next  = leftNode;
                curr = curr.next;
                leftNode = leftNode.next;

            } else {
                curr.next  = rightNode;
                curr = curr.next;
                rightNode = rightNode.next;
            }
        }
        while (leftNode != null) {
            curr.next = leftNode;
            curr = curr.next;
            leftNode = leftNode.next;
        }

        while (rightNode != null) {
            curr.next = rightNode;
            curr = curr.next;
            rightNode = rightNode.next;
        }
        return head.next;
    }


//     // this solution uses a priority queue for all mins at a particular point in time
//     public ListNode mergeKLists_priorityQueue(ListNode[] lists) {
//         if (lists == null) {
//             return null;
//         }
//         ListNode head = null;
//         ListNode curr = null;

//         PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
//         for (int i = 0; i < lists.length; i++) {
//             if (lists[i] != null) {
//                 minHeap.add(lists[i]);
//             }
//         }

//         while (!minHeap.isEmpty()) {
//             ListNode minItem = minHeap.poll();
//             if (head == null) {
//                 head = minItem;
//                 curr = head;
//             } else {
//                 curr.next = minItem;
//                 curr = curr.next;
//             }
//             ListNode nextItemInList = minItem.next;
//             if (nextItemInList != null) {
//                 minHeap.add(nextItemInList);
//             }
//         }

//         return head;

//     }
}

// min heap with comparison based on value that also stores index of the list
// for first val,index in every list
//      minheap.add(value, index)
// while minheap is not empty
//      minItem = minHeap.poll()
//      nexItemInList = lists[minItem.index].next
//      nexItemInList != null ? minHeap.add(nextitemInList, minItem.index)
//