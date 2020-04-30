package main.java;

import main.java.commons.ListNode;

// https://leetcode.com/problems/linked-list-cycle/
// #141. Linked List Cycle
public class LinkedListCycle {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }

            ListNode slow = head;
            ListNode fast = head.next;
            while(fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
}
