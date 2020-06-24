package javasolutions.singlelinkedlist;

import javasolutions.commons.ListNode;

public class MiddleOfLinkedList {
    // https://leetcode.com/problems/middle-of-the-linked-list/submissions/
// 876. Middle of the Linked List
    class Solution {
        public ListNode middleNode(ListNode head) {

            if (head == null) {
                return null;
            }

            ListNode fast = head, slow = head;

            while (fast != null) {
                // since we need to return second of the middle
                if (fast.next != null) {
                    fast = fast.next;
                    slow = slow.next;
                }

                fast = fast.next;
            }
            return slow;
        }
    }
}
