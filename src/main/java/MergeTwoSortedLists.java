package main.java;

import main.java.commons.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode curr = head;

        while(true) {
            ListNode min = getMin(l1, l2);
            if(null==min) {
                return head;
            }
            if(head==null) {
                head = min;
                curr=head;
            } else {
                curr.next=min;
                curr=curr.next;
            }
            if(min==l1) {
                l1=l1.next;
            } else {
                l2=l2.next;
            }
        }
    }

    private ListNode getMin(ListNode l1, ListNode l2) {
        return l1==null? l2 : l2==null? l1 : l1.val<l2.val? l1 : l2;
    }

}