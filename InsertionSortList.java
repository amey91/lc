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
public class InsertionSortList {
   	public ListNode<Integer> insertionSortList(ListNode<Integer> head) {
		if(head==null || head.next==null)
			return head;
		ListNode<Integer> first=head;
		ListNode<Integer> second=head.next;
		//for each element in list
		while(second!=null){
			//insert into correct place
			if(second.val<first.val){
				//if less than head node, insert in beginning
				if(second.val<head.val){
					first.next=second.next;
					second.next=head;
					head=second;
					second=first.next;
				}
				else{
					ListNode<Integer> loopVar=head;
					ListNode<Integer> loopVar2=head.next;
					while(loopVar2!=second && loopVar2.val<second.val){
						loopVar2=loopVar2.next;
						loopVar=loopVar.next;
					}
					if(!(loopVar2==second)){
						// move the second var into its correct position
						first.next = second.next;
						loopVar.next=second;
						second.next=loopVar2;
						second=first.next;
					} else{
					    //increment first and second
					    first = first.next;
			            second = second.next;    
					}
				}
			} else {
			    first = first.next;
			    second = second.next;    
			}
		}
		return head;
	}
}