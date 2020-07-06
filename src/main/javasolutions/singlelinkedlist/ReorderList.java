package javasolutions.singlelinkedlist;

import javasolutions.commons.ListNode;

public class ReorderList {

    // 143. Reorder List
// https://leetcode.com/problems/reorder-list/
    class Solution {

        // find middle
        // reverse from middle
        // merge two lists
        public void reorderList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return;
            }

            ListNode slow = head, fast = head;

            while (fast != null && fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode l1 = head;
            ListNode l2 = slow.next;
            slow.next = null;

            l2 = reverseList(l2);

            mergeLists(l1, l2);
        }

        private ListNode mergeLists(ListNode l1, ListNode l2) {
            // IMPORTANT: sentry node to make solution cleaner
            ListNode head = new ListNode(-1);
            ListNode curr = head;
            while (l1 != null && l2 != null) {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
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

        private ListNode reverseList(ListNode l) {

            ListNode prev = null;
            ListNode curr = l;

            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }
}
