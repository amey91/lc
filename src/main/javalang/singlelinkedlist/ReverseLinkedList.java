package javalang.singlelinkedlist;

import javalang.commons.ListNode;

public class ReverseLinkedList {
    // 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode prev = null, curr = head;
            while (curr != null) {
                ListNode next = curr.next; // 2
                curr.next = prev;
                prev = curr; // 1
                curr = next; // 2
            }
            return prev;
        }
    }
}
