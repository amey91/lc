package leetcode;

import leetcode.commons.ListNode;

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
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if(head==null || head.next==null)
			return head;
		ListNode ltTail=null;
		ListNode ltHead=null;
		ListNode gtTail=null;
		ListNode gtHead=null;
		// assume head -> node -> tail
        while(head!=null){
            if(head.val<x){
                if(ltHead==null){
                    ltHead=new ListNode(head.val);
                    ltTail=ltHead;
                } else {
                    ltTail.next=head;
                    ltTail=ltTail.next;
                }
            } else {
                if(gtHead==null) {
                    gtHead=new ListNode(head.val);
                    gtTail=gtHead;
                } else {
                    gtTail.next=new ListNode(head.val);
                    gtTail=gtTail.next;
                }
            }
            head=head.next;
        }
        if(ltHead==null)
            return gtHead;
        ltTail.next=gtHead;
        return ltHead;
	}
}