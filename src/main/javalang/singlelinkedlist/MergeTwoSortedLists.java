package javalang.singlelinkedlist;

import javalang.commons.ListNode;

public class MergeTwoSortedLists {
    // 21. Merge Two Sorted Lists
// https://leetcode.com/problems/merge-two-sorted-lists/
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1);
            ListNode curr = head;
            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    curr.next = l2;
                    l2 = l2.next;
                } else {
                    curr.next = l1;
                    l1 = l1.next;
                }
                curr = curr.next;
            }

            while (l1 != null) {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            }
            while (l2 != null) {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
            return head.next;
        }
    }
}
