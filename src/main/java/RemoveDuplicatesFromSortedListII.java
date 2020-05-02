package main.java;

import main.java.commons.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
            
        while(head!=null && head.next!=null && head.val==head.next.val){
            int val = head.val;
            while(head!=null && head.val==val)
                head=head.next;
        }
        
        if(head==null||head.next==null)
            return head;
        
        ListNode curr=head;
        ListNode next=head.next;
        while(next!=null && next.next!=null){
            if(next.val==next.next.val){
                int val = next.val;
                ListNode duplicateEnd = next.next;
                while(duplicateEnd!=null && duplicateEnd.val==val)
                    duplicateEnd=duplicateEnd.next;
                curr.next=duplicateEnd;
                if(duplicateEnd==null){
                    return head;
                }
            } else {
                curr=curr.next;
            }
            next=curr.next;
        }       
        return head;
    }
}